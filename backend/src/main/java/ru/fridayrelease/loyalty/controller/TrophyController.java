package ru.fridayrelease.loyalty.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fridayrelease.loyalty.service.TrophyService;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author avbelyaev
 */
@RestController
@RequiredArgsConstructor
public class TrophyController {

    @Nonnull
    private final TrophyService trophyService;

    @GetMapping("/api/users/trophies")
    public ResponseEntity getAllTrophies() {
        Collection<TrophyModel> trophies = this.trophyService
                .getAllTrophies().stream()
                .map(TrophyModel::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(trophies);
    }
}
