package com.riseld.springbexc.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="doctors")

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=3, max=35)
    private String firstName;

    @NotBlank
    @Size(min=3, max=35)
    private String lastName;

    //@Enumerated(EnumType.STRING)
    private String speciality;

    @NotBlank
    @Size(min=5, max=10)
    private String phoneNumber;

    @NotBlank
    private String email;
}
