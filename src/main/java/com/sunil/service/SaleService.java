package com.sunil.service;

import com.sunil.datamodel.dto.SaleDTO;
import com.sunil.datamodel.enumModel.SaleStatus;
import com.sunil.datamodel.vo.SalePurchaseVO;
import com.sunil.model.Coupon;
import com.sunil.model.Sale;
import com.sunil.repository.CouponRepository;
import com.sunil.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class SaleService {
    private final SaleRepository saleRepository;
    private final CouponRepository couponRepository;

    @Autowired
    public SaleService(SaleRepository saleRepository, CouponRepository couponRepository) {
        this.saleRepository = saleRepository;
        this.couponRepository = couponRepository;
    };

    public List<SaleDTO> sales() {
        return this.saleRepository.findAll().stream().map(SaleDTO::new).collect(Collectors.toList());
    };

    public SaleDTO saleBySaleId(int saleId) throws Exception {
        Optional<Sale> searchedSale = this.saleRepository.findById(saleId);

        return new SaleDTO(searchedSale.orElseThrow(() -> new Exception("존재하지 않는 구매 기록입니다")));
    };

    public int addSaleList(SalePurchaseVO sale) throws Exception {
        int discountPrice = 0;

        int couponId = sale.getCouponId();

        Coupon coupon = this.couponRepository.findById(couponId)
                .orElse(new Coupon(0, new Date(), new Date(), 0, 0, 0));

        int couponDiscountPrice = coupon.getDiscountPrice();
        int discountPercentage = coupon.getDiscountPercentage();

        if(couponDiscountPrice != 0 && discountPercentage == 0) {
            discountPrice = couponDiscountPrice;
        }else if(couponDiscountPrice == 0 && discountPercentage != 0) {
            discountPrice = (int)Math.floor(sale.getAmount() + (discountPercentage/100));
        };

        int sold = sale.getSold();
        SaleStatus soldStatus;

        if(sold == 0) {
            soldStatus = SaleStatus.PROGRESSING;
        }else if(sold == 1) {
            soldStatus = SaleStatus.PAID;
        }else {
            soldStatus = SaleStatus.REFUNDED;
        };

        Sale createSale = Sale.builder()
                .buyerId(sale.getBuyerId())
                .productId(sale.getProductId())
                .amount(sale.getAmount())
                .price(sale.getPrice() - discountPrice)
                .saleDate(sale.getSaleDate())
                .sold(soldStatus)
                .build();

        this.saleRepository.save(createSale);
        this.couponRepository.save(coupon);

        this.saleRepository.flush();
        this.couponRepository.flush();

        return createSale.getSaleId();
    };

    public void deleteSaleList(int saleId) {
        this.saleRepository.deleteById(saleId);
    };

    public void initializeSales() {
        Sale sale1 = Sale.builder()
                .buyerId(1)
                .productId(1)
                .amount(1)
                .price(130000)
                .saleDate(new Date())
                .sold(SaleStatus.PAID)
                .build();

        Sale sale2 = Sale.builder()
                .buyerId(2)
                .productId(1)
                .amount(1)
                .price(130000)
                .saleDate(new Date())
                .sold(SaleStatus.PROGRESSING)
                .build();

        Sale sale3 = Sale.builder()
                .buyerId(3)
                .productId(2)
                .amount(1)
                .price(1200000)
                .saleDate(new Date())
                .sold(SaleStatus.REFUNDED)
                .build();

        this.saleRepository.save(sale1);
        this.saleRepository.save(sale2);
        this.saleRepository.save(sale3);
        this.saleRepository.flush();
    };
}
