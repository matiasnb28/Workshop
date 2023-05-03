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
import java.util.Date;

@Entity
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "Name may not be null or empty")
    @Column(length = 35, nullable = false)
    private String firstName;

    @NotBlank(message = "Lastname may not be null or empty")
    @Column(length = 35, nullable = false)
    private String lastName;

    @Column(length = 25, nullable = true)
    private Long phone;

    @Column(length = 200, nullable = true)
    private String address;

    @Column(nullable = false)
    private Boolean deleted;

    @NotBlank(message = "Username may not be null or empty")
    @Column(length = 20, nullable = false)
    private String userName;

    @NotBlank(message = "Password may not be null or empty")
    private String password;

    @CreationTimestamp
    @Column(name = "creation_date", updatable = false)
    private Date creationDate;

    @UpdateTimestamp
    @Column(name = "update_date")
    private Date updateDate;
}

