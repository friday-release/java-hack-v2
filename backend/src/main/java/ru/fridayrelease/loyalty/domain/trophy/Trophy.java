package ru.fridayrelease.loyalty.domain.trophy;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.fridayrelease.loyalty.domain.task.TaskState;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Награда, тенант покупает ее за points
 *
 * @author avbelyaev
 */
@Data
@EqualsAndHashCode
@ToString
@Document(collection = "trophies")
public class Trophy {

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

    @Nullable
    private String productUrl;

    @Builder
    public Trophy(@Nonnull String title,
                  @Nonnull String tenantId,
                  @Nonnull TaskState state,
                  @Nonnull String description,
                  @Nullable LocalDateTime expirationDate,
                  @Nullable String imageUrl,
                  int points,
                  @Nonnull String category,
                  @Nullable String productUrl) {
        this.id = UUID.randomUUID().toString();

        this.title = title;
        this.tenantId = tenantId;
        this.state = state;
        this.description = description;
        this.expirationDate = expirationDate;
        this.imageUrl = imageUrl;
        this.points = points;
        this.category = category;
        this.productUrl = productUrl;
    }

    protected Trophy() {
        // required for mongo
    }
}
