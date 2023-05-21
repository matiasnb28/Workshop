package com.example.PersonalWorkshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "vehicles")
@SQLDelete(sql = "UPDATE vehicles SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Plate may not be null or empty")
    @Column(length = 35, nullable = false)
    private String plate;

    @NotBlank (message = "Model may not be null or empty")
    @Column(length = 35, nullable = false)
    private String model;

    @NotBlank (message = "Brand may not be null or empty")
    @Column(length = 35, nullable = false)
    private String brand;

    @NotBlank (message = "Year may not be null or empty")
    @Column(length = 35, nullable = false)
    private String year;

    @Column(length = 35, nullable = false)
    private String km;

    private boolean deleted = Boolean.FALSE;

    @ManyToOne(fetch = FetchType.EAGER, cascade =  CascadeType.PERSIST)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "user_id")
    private Long userId;

    @CreationTimestamp
    @Column(name = "creation_date", updatable = false)
    private LocalDateTime creationDate = LocalDateTime.now();

    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    private String state; //TODO Cambiar en algún momento a un Enum

    //private String greenCard; //TODO hacer relación con entidad correspondiente

    private String image; //TODO será para la tarjeta verde del vehículo
}

