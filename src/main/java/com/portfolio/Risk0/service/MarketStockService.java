package com.portfolio.Risk0.service;

import com.portfolio.Risk0.model.MarketStock;
import com.portfolio.Risk0.repository.MarketStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarketStockService {

    private final MarketStockRepository marketStockRepository;

    public List<MarketStock> getAllMarketStocks() {
        return marketStockRepository.findAll();
    }

    public MarketStock getMarketStockById(Long id) {
        return marketStockRepository.findById(id).orElse(null);
    }

    public MarketStock getMarketStockBySymbol(String symbol) {
        return marketStockRepository.findBySymbol(symbol).orElse(null);
    }

    public List<MarketStock> getMarketStocksBySector(String sector) {
        return marketStockRepository.findBySector(sector);
    }

    public MarketStock addMarketStock(MarketStock marketStock) {
        return marketStockRepository.save(marketStock);
    }

    public MarketStock updateMarketStock(Long id, MarketStock marketStock) {
        marketStock.setId(id);
        return marketStockRepository.save(marketStock);
    }

    public void deleteMarketStock(Long id) {
        marketStockRepository.deleteById(id);
    }
}
