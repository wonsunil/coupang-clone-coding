package com.sunil.datamodel.dto;

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
    private String name;
    private int price;
    private Date saleDate;
    private int sold;

    public SaleDTO(Sale sale) {
        this.saleId = sale.getSaleId();
        this.buyerId = sale.getBuyerId();
        this.productId = sale.getProductId();
        this.name = sale.getName();
        this.price = sale.getPrice();
        this.saleDate = sale.getSaleDate();
        this.sold = sale.getSold();
    };

    @Override
    public String toString() {
        return String.format(
                "SaleDTO[saleId=%d, buryerId=%d, productId=%d, name='%s', price=%d, saleDate='%s', sold=%d]",
                this.saleId, this.buyerId, this.productId, this.name, this.price, this.saleDate, this.sold
        );
    };
};
