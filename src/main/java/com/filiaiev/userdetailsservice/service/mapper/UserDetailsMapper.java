package com.filiaiev.userdetailsservice.service.mapper;

import com.filiaiev.userdetailsservice.model.UserDetails;
import com.filiaiev.userdetailsservice.repository.user.UserDetailsDO;
import org.mapstruct.Mapper;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Mapper(componentModel = "spring")
public interface UserDetailsMapper {


    UserDetails mapUserDetailsDOToUserDetails(UserDetailsDO userDetailsDO);

    default OffsetDateTime mapInstantToOffsetDateTime(Instant instant) {
        return OffsetDateTime.ofInstant(instant, ZoneOffset.UTC);
    }
}
