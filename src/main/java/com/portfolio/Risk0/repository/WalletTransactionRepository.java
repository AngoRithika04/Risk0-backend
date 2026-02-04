package com.portfolio.Risk0.repository;

import com.portfolio.Risk0.model.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletTransactionRepository extends JpaRepository<WalletTransaction, Long> {
    List<WalletTransaction> findByWalletId(Long walletId);
    List<WalletTransaction> findByWalletIdOrderByTransactionDateDesc(Long walletId);
}
