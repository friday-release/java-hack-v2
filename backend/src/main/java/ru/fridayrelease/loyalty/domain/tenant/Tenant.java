package ru.fridayrelease.loyalty.domain.tenant;

import lombok.*;
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
@Builder
public class Tenant {

    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();

    @Nonnull
    private Profile profile;

    @Nonnull
    private String ogrn;

    private long points;


    @Builder
    @Getter
    public static class Profile {

        private String firstName;

        private String lastName;
    }
}
