package com.portfolio.Risk0.controller;

import com.portfolio.Risk0.model.Transaction;
import com.portfolio.Risk0.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransactions(
            @RequestParam(required = false) String symbol,
            @RequestParam(required = false) Long userId) {
        return transactionService.getTransactionsBySymbol(symbol, userId);
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.addTransaction(transaction);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }
}
