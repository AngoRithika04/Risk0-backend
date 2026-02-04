package com.portfolio.Risk0.repository;

import com.portfolio.Risk0.model.StockPriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockPriceHistoryRepository extends JpaRepository<StockPriceHistory, Long> {
    List<StockPriceHistory> findBySymbol(String symbol);
    List<StockPriceHistory> findBySymbolOrderByRecordedAtDesc(String symbol);
}
