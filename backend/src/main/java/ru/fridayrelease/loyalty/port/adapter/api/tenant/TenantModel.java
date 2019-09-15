package ru.fridayrelease.loyalty.port.adapter.api.tenant;

import lombok.Data;
import ru.fridayrelease.loyalty.domain.tenant.Tenant;

import javax.annotation.Nonnull;

@Data
class TenantModel {

    @Nonnull
    private String id;

    private String brandTitle;

    private String tenantTitle;

    @Nonnull
    private ProfileModel profile;

    @Nonnull
    private String ogrn;

    private long points;

    TenantModel(Tenant tenant) {
        this.id = tenant.getId();
        this.brandTitle = tenant.getBrandTitle();
        this.tenantTitle = tenant.getTenantTitle();
        this.ogrn = tenant.getOgrn();
        this.points = tenant.getPoints();
        this.profile = new ProfileModel(tenant.getProfile());
    }

    @Data
    public static class ProfileModel {

        private String firstName;

        private String lastName;

        private String avatarUrl;

        ProfileModel(Tenant.Profile profile) {
            this.firstName = profile.getFirstName();
            this.lastName = profile.getLastName();
            this.avatarUrl = profile.getAvatarUrl();
        }
    }
}


