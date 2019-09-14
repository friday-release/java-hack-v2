package ru.fridayrelease.loyalty.port.adapter.api.trophy;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import ru.fridayrelease.loyalty.domain.trophy.Trophy;

import java.util.List;

/**
 * @author avbelyaev
 */
@AllArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TrophiesModel {

    private List<TrophyModel> trophies;

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public class TrophyModel {

        private final String id;

        private final String name;

        public TrophyModel(Trophy trophy) {
            this.id = trophy.getId();
            this.name = trophy.getTitle();
        }
    }
}
