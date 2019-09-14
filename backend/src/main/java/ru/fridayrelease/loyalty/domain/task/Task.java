package ru.fridayrelease.loyalty.domain.task;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.fridayrelease.loyalty.domain.task.exception.InvalidTaskStateException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * @author avbelyaev
 */
@Data
@EqualsAndHashCode
@ToString
@Document(collection = "tasks")
@Builder
public class Task {

    @Id
    @Builder.Default
    private String id;

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

    protected Task() {
        // required for mongo
    }

    /**
     * if transition is denied, {@link InvalidTaskStateException} is thrown
     */
    public void transitTo(@Nonnull TaskState newState) {
        if (this.state.cantTransitTo(newState)) {
            this.state = newState;

        } else {
            throw new InvalidTaskStateException();
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
