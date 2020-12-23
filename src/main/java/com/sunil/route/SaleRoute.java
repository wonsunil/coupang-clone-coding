package com.sunil.route;

import com.sunil.datamodel.dto.SaleDTO;
import com.sunil.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleRoute {
    private final SaleService saleService;

    @Autowired
    public SaleRoute(SaleService saleService) {
        this.saleService = saleService;
    };

    @GetMapping("")
    public List<SaleDTO> getSales() {
        return this.saleService.sales();
    };

    @GetMapping("/{saleId}")
    public SaleDTO getSaleById(@PathVariable(value = "saleId") String saleId) throws Exception {
        return this.saleService.saleBySaleId(Integer.parseInt(saleId));
    };
};
