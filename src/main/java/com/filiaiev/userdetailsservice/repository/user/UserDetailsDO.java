package com.filiaiev.userdetailsservice.repository.user;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.time.Instant;
import java.time.LocalDate;

@Entity(name = "user_details")
@Data
public class UserDetailsDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String middleName;
    @Convert(converter = UserGenderDOConverter.class)
    private GenderDO gender;
    private LocalDate dob;
    private String mobile;
    private String city;
    private String country;
    private String addressLine1;
    private String addressLine2;
    private String postcode;
    private Instant createdAt;
}
