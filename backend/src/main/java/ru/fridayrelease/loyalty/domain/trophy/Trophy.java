package ru.fridayrelease.loyalty.domain.trophy;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Награда, тенант покупает ее за pointsCost
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
    private TrophyState state;

    @Nonnull
    private String description;

    @Nullable
    private LocalDateTime expirationDate;

    @Nullable
    private String imageUrl;

    private int pointsCost;

    @Nonnull
    private String category;

    @Nullable
    private String productUrl;

    @Builder
    public Trophy(@Nonnull String title,
                  @Nonnull String tenantId,
                  @Nonnull TrophyState state,
                  @Nonnull String description,
                  @Nullable LocalDateTime expirationDate,
                  @Nullable String imageUrl,
                  int pointsCost,
                  @Nonnull String category,
                  @Nullable String productUrl) {
        this.id = UUID.randomUUID().toString();

        this.title = title;
        this.tenantId = tenantId;
        this.state = state;
        this.description = description;
        this.expirationDate = expirationDate;
        this.imageUrl = imageUrl;
        this.pointsCost = pointsCost;
        this.category = category;
        this.productUrl = productUrl;
    }

    protected Trophy() {
        // required for mongo
    }
}
