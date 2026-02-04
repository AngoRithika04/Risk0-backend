package com.portfolio.Risk0.repository;

import com.portfolio.Risk0.model.Holding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoldingRepository extends JpaRepository<Holding, Long> {
    List<Holding> findByUserId(Long userId);
    List<Holding> findByUserIdAndSymbol(Long userId, String symbol);
    List<Holding> findByUserIdAndTimePeriod(Long userId, String timePeriod);
}
