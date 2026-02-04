package com.portfolio.Risk0.repository;

import com.portfolio.Risk0.model.InvestmentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvestmentCategoryRepository extends JpaRepository<InvestmentCategory, Long> {
    List<InvestmentCategory> findByUserId(Long userId);
    Optional<InvestmentCategory> findByUserIdAndCategoryType(Long userId, String categoryType);
}
