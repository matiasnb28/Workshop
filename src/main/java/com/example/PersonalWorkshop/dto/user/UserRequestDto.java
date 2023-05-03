package com.example.PersonalWorkshop.dto.user;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    @NotBlank(message = "name cannot be null")
    private String firstName;

    @NotBlank(message = "lastname cannot be null")
    private String lastname;

    @NotBlank(message = "phone cannot be null")
    private String phone;

    private String address;
    @NotBlank(message = "username cannot be null")
    private String username;

    @NotBlank(message = "password cannot be null")
    private String password;

}
