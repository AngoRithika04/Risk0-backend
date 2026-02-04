package com.portfolio.Risk0.service;

import com.portfolio.Risk0.model.FinancialGoal;
import com.portfolio.Risk0.repository.FinancialGoalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinancialGoalService {

    private final FinancialGoalRepository financialGoalRepository;

    public List<FinancialGoal> getAllFinancialGoals() {
        return financialGoalRepository.findAll();
    }

    public List<FinancialGoal> getFinancialGoalsByUserId(Long userId) {
        return financialGoalRepository.findByUserId(userId);
    }

    public FinancialGoal getFinancialGoalById(Long id) {
        return financialGoalRepository.findById(id).orElse(null);
    }

    public FinancialGoal addFinancialGoal(FinancialGoal financialGoal) {
        return financialGoalRepository.save(financialGoal);
    }

    public FinancialGoal updateFinancialGoal(Long id, FinancialGoal financialGoal) {
        financialGoal.setId(id);
        return financialGoalRepository.save(financialGoal);
    }

    public void deleteFinancialGoal(Long id) {
        financialGoalRepository.deleteById(id);
    }
}
