package com.example.PersonalWorkshop.dto.budget;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BudgetResponseDto {

private Long vehicleId;
private Long userId;
private String faultDescription;
private Float total;
private Integer quantity;
private String detail;
private Float price;
}
