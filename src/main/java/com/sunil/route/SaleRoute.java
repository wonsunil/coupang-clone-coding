package com.sunil.route;

import com.sunil.datamodel.dto.SaleDTO;
import com.sunil.datamodel.vo.SalePurchaseVO;
import com.sunil.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleRoute {
    private final SaleService saleService;

    @Autowired
    public SaleRoute(SaleService saleService) {
        this.saleService = saleService;
    };

    @GetMapping("/initialize")
    public void initialize() {
        this.saleService.initializeSales();
    };

    @GetMapping("")
    public List<SaleDTO> getSales() {
        return this.saleService.sales();
    };

    @GetMapping("/{saleId}")
    public SaleDTO getSaleById(@PathVariable(value = "saleId") String saleId) throws Exception {
        return this.saleService.saleBySaleId(Integer.parseInt(saleId));
    };

    @PostMapping
    public int addSaleList(SalePurchaseVO sale) throws Exception {
        return this.saleService.addSaleList(sale);
    };

    @DeleteMapping("{saleId}")
    public void deleteSaleList(@PathVariable(value = "saleId") String saleId) {
        this.saleService.deleteSaleList(Integer.parseInt(saleId));
    };
};
