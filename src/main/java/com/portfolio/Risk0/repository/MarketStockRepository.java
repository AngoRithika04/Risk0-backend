package com.portfolio.Risk0.repository;

import com.portfolio.Risk0.model.MarketStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarketStockRepository extends JpaRepository<MarketStock, Long> {
    Optional<MarketStock> findBySymbol(String symbol);
    List<MarketStock> findBySector(String sector);
}
