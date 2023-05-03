package com.example.PersonalWorkshop.dto.budget;

import com.example.PersonalWorkshop.model.User;
import com.example.PersonalWorkshop.model.Vehicle;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BudgetRequestDto {

    @NotBlank(message = "Vehicle can't be null or empty")
    private Long vehicleId;
    @NotBlank(message = "User can't be null or empty")
    private Long userId;
    @NotBlank(message = "Full descritpion can't be null or empty")
    private String faultDescription;

    private Float total;
    @NotBlank(message = "Quantity can't be null or empty")
    private Integer quantity;
    @NotBlank(message = "Detail can't be null or empty")
    private String detail;
    @NotBlank(message = "Price can't be null or empty")
    private Float price;

}
