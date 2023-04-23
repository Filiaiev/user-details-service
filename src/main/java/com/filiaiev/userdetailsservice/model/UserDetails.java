package com.filiaiev.userdetailsservice.model;

import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.time.OffsetDateTime;

@Data
public class UserDetails {

    @Id
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String middleName;
    private Gender gender;
    private LocalDate dob;
    private String mobile;
    private String city;
    private String country;
    private String addressLine1;
    private String addressLine2;
    private String postcode;
    private OffsetDateTime createdAt;
}
