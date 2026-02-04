package com.portfolio.Risk0.repository;

import com.portfolio.Risk0.model.LearningStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LearningStatsRepository extends JpaRepository<LearningStats, Long> {
    Optional<LearningStats> findByUserId(Long userId);
}
