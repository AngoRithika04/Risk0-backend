package com.portfolio.Risk0.controller;

import com.portfolio.Risk0.model.MarketStock;
import com.portfolio.Risk0.service.MarketStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/market-stocks")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class MarketStockController {

    private final MarketStockService marketStockService;

    @GetMapping
    public List<MarketStock> getAllMarketStocks(@RequestParam(required = false) String sector) {
        if (sector != null) {
            return marketStockService.getMarketStocksBySector(sector);
        }
        return marketStockService.getAllMarketStocks();
    }

    @GetMapping("/{id}")
    public MarketStock getMarketStockById(@PathVariable Long id) {
        return marketStockService.getMarketStockById(id);
    }

    @GetMapping("/symbol/{symbol}")
    public MarketStock getMarketStockBySymbol(@PathVariable String symbol) {
        return marketStockService.getMarketStockBySymbol(symbol);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MarketStock addMarketStock(@RequestBody MarketStock marketStock) {
        return marketStockService.addMarketStock(marketStock);
    }

    @PutMapping("/{id}")
    public MarketStock updateMarketStock(@PathVariable Long id, @RequestBody MarketStock marketStock) {
        return marketStockService.updateMarketStock(id, marketStock);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMarketStock(@PathVariable Long id) {
        marketStockService.deleteMarketStock(id);
    }
}
