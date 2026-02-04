package com.portfolio.Risk0.controller;

import com.portfolio.Risk0.model.Holding;
import com.portfolio.Risk0.service.HoldingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holdings")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class HoldingController {

    private final HoldingService holdingService;

    @GetMapping
    public ResponseEntity<List<Holding>> getAllHoldings(@RequestParam(required = false) String timePeriod) {
        List<Holding> holdings = holdingService.getAllHoldings(timePeriod);
        return ResponseEntity.ok(holdings);
    }

    @PostMapping
    public ResponseEntity<Holding> createHolding(@RequestBody Holding holding) {
        Holding createdHolding = holdingService.createHolding(holding);
        return ResponseEntity.ok(createdHolding);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Holding> updateHolding(@PathVariable Long id, @RequestBody Holding holding) {
        return holdingService.updateHolding(id, holding)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHolding(@PathVariable Long id) {
        boolean deleted = holdingService.deleteHolding(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
