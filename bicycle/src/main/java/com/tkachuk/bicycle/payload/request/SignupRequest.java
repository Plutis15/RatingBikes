package com.tkachuk.bicycle.payload.request;

import lombok.Data;
import com.tkachuk.bicycle.entity.enums.UserRoles;

@Data
//@AllArgsConstructor
public class SignupRequest {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private String imageURL;
    private UserRoles role;

    public SignupRequest(String username, String password, String email, String firstName, String lastName, String address, String imageURL, UserRoles role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.imageURL = imageURL;
        this.role = role;
    }
}
