package ru.fridayrelease.loyalty.port.adapter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author avbelyaev
 */
@RestController
public class UsersResource {

    @GetMapping("/api/users")
    public ResponseEntity<UserModel> getUsers() {
        return ResponseEntity.ok(new UserModel("john"));
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    private static class UserModel {

        private String name;

        public UserModel(String name) {
            this.name = name;
        }
    }
}
