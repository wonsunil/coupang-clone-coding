package com.sunil.datamodel.dto;

import com.sunil.datamodel.enumModel.SaleStatus;
import com.sunil.model.Sale;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class SaleDTO {
    private int saleId;
    private int buyerId;
    private int productId;
    private int amount;
    private int price;
    private String saleDate;
    private SaleStatus sold;

    public SaleDTO(Sale sale) {
        this.saleId = sale.getSaleId();
        this.buyerId = sale.getBuyerId();
        this.productId = sale.getProductId();
        this.amount = sale.getAmount();
        this.price = sale.getPrice();
        this.saleDate = sale.getSaleDate();
        this.sold = sale.getSold();
    };

    @Override
    public String toString() {
        return String.format(
                "SaleDTO[saleId=%d, buyerId=%d, productId=%d, amount=%d, price=%d, saleDate='%s', sold=%d]",
                this.saleId, this.buyerId, this.productId, this.amount, this.price, this.saleDate, this.sold
        );
    };
};
