package ru.fridayrelease.loyalty.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import ru.fridayrelease.loyalty.dao.trophy.Trophy;

/**
 * @author avbelyaev
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TrophyModel {

    private final String id;

    private final String name;

    public TrophyModel(Trophy trophy) {
        this.id = trophy.getId();
        this.name = trophy.getName();
    }
}
