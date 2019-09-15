package ru.fridayrelease.loyalty.domain.task;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.fridayrelease.loyalty.domain.task.exception.InvalidTaskStateException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

/**
 * @author avbelyaev
 */
@Data
@Document(collection = "tasks")
public class Task {

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @Nonnull
    private String title;

    @Nonnull
    private TaskState state;

    private long points;

    @Nonnull
    private String tenantId;

    @Nonnull
    private String description;

    @Nullable
    private Progress progress;

    @Nullable
    private List<String> conditions;

    // TODO make enum
    @Nonnull
    private String category;

    @Builder
    public Task(@Nonnull String title, @Nonnull TaskState state, long points, @Nonnull String tenantId, @Nonnull String description, @Nullable Progress progress, @Nullable List<String> conditions, @Nonnull String category) {
        this.title = title;
        this.state = state;
        this.points = points;
        this.tenantId = tenantId;
        this.description = description;
        this.progress = progress;
        this.conditions = conditions;
        this.category = category;
    }

    protected Task() {
        // required for mongo
    }

    /**
     * if transition is denied, {@link InvalidTaskStateException} is thrown
     */
    public void transitTo(@Nonnull TaskState newState) {
        if (this.state.cantTransitTo(newState)) {
            this.state = newState;

        }
    }

    /**
     * прогресс выполнения задачи: (4/30)
     */
    @Data
    @Builder
    public static class Progress {
        private int current;

        private int all;
    }

}
