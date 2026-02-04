package com.portfolio.Risk0.repository;

import com.portfolio.Risk0.model.PortfolioSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortfolioSummaryRepository extends JpaRepository<PortfolioSummary, Long> {
    Optional<PortfolioSummary> findByUserId(Long userId);
}
