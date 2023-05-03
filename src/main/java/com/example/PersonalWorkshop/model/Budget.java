package com.example.PersonalWorkshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "budgets")
@SQLDelete(sql = "UPDATE budgets SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", insertable = false, updatable = false)
    private Vehicle vehicle;

    @Column(name = "vehicle_id")
    private Long vehicleId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "user_id")
    private Long userId;

    @NotBlank(message = "Fault Description may not be null or empty")
    @Column(length = 255, nullable = false)
    private String faultDescription;


    private Float total;

    @NotBlank(message = "Quantity may not be null or empty")
    @Column(nullable = false)
    private Integer quantity; //Cantidad de productos. Ej: 2 amortiguadores

    @NotBlank(message = "Detail may not be null or empty")
    @Column(length = 100, nullable = false)
    private String detail; //Detalle de productos. Ej: Amortiguadores

    @NotBlank(message = "Price may not be null or empty")
    @Column(nullable = false)
    private Float price;


}
