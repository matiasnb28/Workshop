package com.example.PersonalWorkshop.dto.vehicle;

import com.example.PersonalWorkshop.model.User;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class VehicleResponseDto {

    private Long id;

    private String plate;

    private String model;

    private String brand;

    private String year;

    private String km;

    private User user;
}
