package com.example.PersonalWorkshop.dto.vehicle;

import com.example.PersonalWorkshop.model.User;
import lombok.*;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequestDto {


    @NotBlank(message = "plate cannot be null")
    private String plate;
    @NotBlank(message = "model cannot be null")
    private String model;
    @NotBlank(message = "brand cannot be null")
    private String brand;

    private String year;

    private String km;


}
