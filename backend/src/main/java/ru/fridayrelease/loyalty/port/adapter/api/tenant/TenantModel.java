package ru.fridayrelease.loyalty.port.adapter.api.tenant;

import lombok.Builder;
import ru.fridayrelease.loyalty.domain.tenant.Tenant;

import javax.annotation.Nonnull;

public class TenantModel {

    private String id;

    @Nonnull
    private ProfileModel profile;

    @Nonnull
    private String ogrn;

    private long points;

    TenantModel(Tenant tenant) {
        this.id = tenant.getId();
        this.ogrn = tenant.getOgrn();
        this.points = tenant.getPoints();
        this.profile = new ProfileModel(tenant.getProfile());
    }

    public static class ProfileModel {

        private String firstName;

        private String lastName;

        ProfileModel(Tenant.Profile profile) {
            this.firstName = profile.getFirstName();
            this.lastName = profile.getLastName();
        }
    }
}


