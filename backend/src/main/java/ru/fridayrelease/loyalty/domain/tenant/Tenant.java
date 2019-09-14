package ru.fridayrelease.loyalty.domain.tenant;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Nonnull;
import java.util.UUID;

/**
 * ИП, лицо выполняющее задания
 *
 * @author avbelyaev
 */
@Data
@EqualsAndHashCode
@ToString
@Document(collection = "tenants")
public class Tenant {

    @Id
    private String id;

    @Nonnull
    private Profile profile;

    @Nonnull
    private String ogrn;

    private long points;

    @Builder
    public Tenant(@Nonnull Profile profile,
                  @Nonnull String ogrn,
                  long points) {
        this.id = UUID.randomUUID().toString();

        this.profile = profile;
        this.ogrn = ogrn;
        this.points = points;
    }

    @Builder
    public static class Profile {

        private String firstName;

        private String lastName;
    }
}
