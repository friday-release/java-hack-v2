package ru.fridayrelease.loyalty.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import ru.fridayrelease.loyalty.dao.Achievement;

/**
 * @author avbelyaev
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AchievementModel {

    private final String id;

    private final String name;

    public AchievementModel(Achievement achievement) {
        this.id = achievement.getId();
        this.name = achievement.getName();
    }
}
