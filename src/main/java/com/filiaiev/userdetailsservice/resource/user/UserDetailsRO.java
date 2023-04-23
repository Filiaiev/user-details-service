package com.filiaiev.userdetailsservice.resource.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class UserDetailsRO {

    private String email;
    private String firstName;
    private String lastName;
    private String middleName;
    private GenderRO gender;
    private LocalDate dob;
    private String mobile;
    private String city;
    private String country;
    private String addressLine1;
    private String addressLine2;
    private String postcode;
}
