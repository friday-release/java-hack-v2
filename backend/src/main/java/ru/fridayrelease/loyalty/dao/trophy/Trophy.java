package ru.fridayrelease.loyalty.dao.trophy;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

/**
 * @author avbelyaev
 */
@Data
@EqualsAndHashCode
@ToString
@Document(collection = "trophies")
public class Trophy {

    @Id
    private String id;

    private String name;

    @Builder
    public Trophy(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    protected Trophy() {
        // required for mongo
    }
}
