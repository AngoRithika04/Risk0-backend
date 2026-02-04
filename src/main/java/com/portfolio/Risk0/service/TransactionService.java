package com.portfolio.Risk0.service;

import com.portfolio.Risk0.model.Transaction;
import com.portfolio.Risk0.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getTransactionsBySymbol(String symbol, Long userId) {
        if (symbol != null && userId != null) {
            return transactionRepository.findByUserIdAndSymbol(userId, symbol);
        } else if (userId != null) {
            return transactionRepository.findByUserId(userId);
        }
        return transactionRepository.findAll();
    }

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
