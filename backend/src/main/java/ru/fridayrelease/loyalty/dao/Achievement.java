package ru.fridayrelease.loyalty.dao;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.UUID;

/**
 * @author avbelyaev
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED) // for mongo
@ToString
public class Achievement {

    @Id
    private String id;

    private String name;

    @Builder
    public Achievement(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }
}
