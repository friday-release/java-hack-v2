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
import java.time.LocalDateTime;
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
    private String tenantId;

    @Nonnull
    private TaskState state;

    @Nonnull
    private String description;

    @Nullable
    private LocalDateTime expirationDate;

    @Nullable
    private String imageUrl;

    private int points;

    @Nonnull
    private String category;

    @Builder
    public Task(@Nonnull String title,
                @Nonnull String tenantId,
                @Nonnull TaskState state,
                @Nonnull String description,
                @Nullable LocalDateTime expirationDate,
                @Nullable String imageUrl,
                int points,
                @Nonnull String category) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.tenantId = tenantId;
        this.state = state;
        this.description = description;
        this.expirationDate = expirationDate;
        this.imageUrl = imageUrl;
        this.points = points;
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

        } else {
            throw new InvalidTaskStateException();
        }
    }

}
