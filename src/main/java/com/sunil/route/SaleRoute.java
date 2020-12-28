package com.sunil.route;

import com.sunil.datamodel.dto.SaleDTO;
import com.sunil.datamodel.vo.SalePurchaseVO;
import com.sunil.service.SaleService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "판매기록 기초 생성")
    @GetMapping("/initialize")
    public void initialize() {
        this.saleService.initializeSales();
    };

    @ApiOperation(value = "판매기록 전체 조회")
    @GetMapping("")
    public List<SaleDTO> getSales() {
        return this.saleService.sales();
    };

    @ApiOperation(value = "판매기록 조회")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "saleId", value = "판매 ID", required = true, dataType = "string"),
    })
    @GetMapping("/{saleId}")
    public SaleDTO getSaleById(@PathVariable(value = "saleId") String saleId) throws Exception {
        return this.saleService.saleBySaleId(Integer.parseInt(saleId));
    };

    @ApiOperation(value = "판매기록 추가")
    @PostMapping
    public int addSaleList(SalePurchaseVO sale) throws Exception {
        return this.saleService.addSaleList(sale);
    };

    @ApiOperation(value = "판매기록 삭제")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "saleId", value = "판매 ID", required = true, dataType = "string"),
    })
    @DeleteMapping("{saleId}")
    public void deleteSaleList(@PathVariable(value = "saleId") String saleId) {
        this.saleService.deleteSaleList(Integer.parseInt(saleId));
    };
};
