package com.example.PersonalWorkshop.dto.user;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String phone;

    private String address;

    private String username;

    //TODO revisar de hacer la clase rol
    //private String role;
}
