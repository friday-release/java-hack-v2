package ru.fridayrelease.loyalty.domain.task;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Nonnull;
import java.util.UUID;

/**
 * @author avbelyaev
 */
@Data
@EqualsAndHashCode
@ToString
@Document(collection = "tasks")
public class Task {

    @Id
    private String id;

    private String title;

    @Builder
    public Task(@Nonnull String title) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
    }

    protected Task() {
        // required for mongo
    }

}
