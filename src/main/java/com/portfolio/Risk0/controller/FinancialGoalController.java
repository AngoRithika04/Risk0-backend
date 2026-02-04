package com.portfolio.Risk0.controller;

import com.portfolio.Risk0.model.FinancialGoal;
import com.portfolio.Risk0.service.FinancialGoalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/financial-goals")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class FinancialGoalController {

    private final FinancialGoalService financialGoalService;

    @GetMapping
    public List<FinancialGoal> getAllFinancialGoals(@RequestParam(required = false) Long userId) {
        if (userId != null) {
            return financialGoalService.getFinancialGoalsByUserId(userId);
        }
        return financialGoalService.getAllFinancialGoals();
    }

    @GetMapping("/{id}")
    public FinancialGoal getFinancialGoalById(@PathVariable Long id) {
        return financialGoalService.getFinancialGoalById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FinancialGoal addFinancialGoal(@RequestBody FinancialGoal financialGoal) {
        return financialGoalService.addFinancialGoal(financialGoal);
    }

    @PutMapping("/{id}")
    public FinancialGoal updateFinancialGoal(@PathVariable Long id, @RequestBody FinancialGoal financialGoal) {
        return financialGoalService.updateFinancialGoal(id, financialGoal);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFinancialGoal(@PathVariable Long id) {
        financialGoalService.deleteFinancialGoal(id);
    }
}
