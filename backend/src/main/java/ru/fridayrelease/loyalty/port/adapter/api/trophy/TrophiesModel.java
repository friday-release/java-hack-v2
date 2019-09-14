package ru.fridayrelease.loyalty.port.adapter.api.trophy;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import ru.fridayrelease.loyalty.domain.trophy.Trophy;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author avbelyaev
 */
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TrophiesModel {

    private List<TrophyModel> trophies;

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class TrophyModel {

        @Id
        private String id;

        @Nonnull
        private String title;

        @Nonnull
        private String state;

        @Nonnull
        private String description;

        @Nullable
        private LocalDateTime expirationDate;

        @Nullable
        private String imgUrl;

        private int points;

        @Nonnull
        private String category;

        @Nullable
        private String productUrl;

        public TrophyModel(@Nonnull Trophy trophy) {
            this.id = trophy.getId();
            this.title = trophy.getTitle();
            this.state = trophy.getState().name();
            this.description = trophy.getDescription();
            this.expirationDate = trophy.getExpirationDate();
            this.imgUrl = trophy.getImageUrl();
            this.category = trophy.getCategory();
            this.productUrl = trophy.getProductUrl();
            this.points = trophy.getPointsCost();
        }
    }
}
