package ru.fridayrelease.loyalty.domain.task;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
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

    @Nonnull
    private String title;

    @Nonnull
    private String description;

    @Nullable
    private Progress progress;

    @Nullable
    private List<String> conditions;

    @Nonnull
    private String category;

    @Builder
    public Task(@Nonnull String title,
                @Nonnull String description,
                @Nullable Progress progress,
                @Nullable List<String> conditions,
                @Nonnull String category) {
        this.id = UUID.randomUUID().toString();

        this.title = title;
        this.description = description;
        this.progress = progress;
        this.conditions = conditions;
        this.category = category;

    }

    protected Task() {
        // required for mongo
    }

    /**
     * прогресс выполнения задачи: (4/30)
     */
    @Data
    public static class Progress {
        private int current;

        private int all;
    }

}
