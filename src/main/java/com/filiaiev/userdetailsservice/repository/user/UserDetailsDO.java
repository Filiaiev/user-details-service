package com.filiaiev.userdetailsservice.repository.user;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;

@Entity(name = "user_details")
@Data
public class UserDetailsDO {

    @Id
    @Column(name = "user_id")
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
