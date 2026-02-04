package com.portfolio.Risk0.service;

import com.portfolio.Risk0.model.Holding;
import com.portfolio.Risk0.repository.HoldingRepository;
import com.portfolio.Risk0.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HoldingService {

    private final HoldingRepository holdingRepository;
    private final UserRepository userRepository;

    public List<Holding> getAllHoldings(String timePeriod) {
        Long userId = userRepository.findAll().stream()
                .findFirst()
                .map(user -> user.getId())
                .orElse(null);

        if (userId == null) {
            return List.of();
        }

        if (timePeriod != null && !timePeriod.isEmpty()) {
            return holdingRepository.findByUserIdAndTimePeriod(userId, timePeriod);
        }

        return holdingRepository.findByUserId(userId);
    }

    public Holding createHolding(Holding holding) {
        Long userId = userRepository.findAll().stream()
                .findFirst()
                .map(user -> user.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        holding.setUser(userRepository.findById(userId).orElseThrow());
        return holdingRepository.save(holding);
    }

    public Optional<Holding> updateHolding(Long id, Holding holding) {
        return holdingRepository.findById(id)
                .map(existingHolding -> {
                    existingHolding.setSymbol(holding.getSymbol());
                    existingHolding.setCompanyName(holding.getCompanyName());
                    existingHolding.setSector(holding.getSector());
                    existingHolding.setCurrentPrice(holding.getCurrentPrice());
                    existingHolding.setTimePeriod(holding.getTimePeriod());
                    existingHolding.setQuantity(holding.getQuantity());
                    existingHolding.setTotalInvested(holding.getTotalInvested());
                    existingHolding.setAcquiredDate(holding.getAcquiredDate());
                    return holdingRepository.save(existingHolding);
                });
    }

    public boolean deleteHolding(Long id) {
        if (holdingRepository.existsById(id)) {
            holdingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
