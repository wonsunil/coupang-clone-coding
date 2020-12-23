package com.sunil.service;

import com.sunil.datamodel.dto.SaleDTO;
import com.sunil.datamodel.enumModel.SaleStatus;
import com.sunil.model.Sale;
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

    @Autowired
    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    };

    public List<SaleDTO> sales() {
        return this.saleRepository.findAll().stream().map(SaleDTO::new).collect(Collectors.toList());
    };

    public SaleDTO saleBySaleId(int saleId) throws Exception {
        Optional<Sale> searchedSale = this.saleRepository.findById(saleId);

        return new SaleDTO(searchedSale.orElseThrow(() -> new Exception("존재하지 않는 구매 기록입니다")));
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
                .sold(SaleStatus.PAID)
                .build();

        Sale sale3 = Sale.builder()
                .buyerId(3)
                .productId(2)
                .amount(1)
                .price(1200000)
                .saleDate(new Date())
                .sold(SaleStatus.PAID)
                .build();

        this.saleRepository.save(sale1);
        this.saleRepository.save(sale2);
        this.saleRepository.save(sale3);
        this.saleRepository.flush();
    };
}
