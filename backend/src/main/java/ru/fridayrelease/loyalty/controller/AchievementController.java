package ru.fridayrelease.loyalty.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fridayrelease.loyalty.service.AchievementService;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author avbelyaev
 */
@RestController
@RequiredArgsConstructor
public class AchievementController {

    @Nonnull
    private final AchievementService achievementService;

    @GetMapping("/api/achievements")
    public ResponseEntity getAllCanteens() {
        Collection<AchievementModel> allAchievements = this.achievementService
                .getAllAchievements().stream()
                .map(AchievementModel::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(allAchievements);
    }
}
