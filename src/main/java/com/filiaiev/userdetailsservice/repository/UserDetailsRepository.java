package com.filiaiev.userdetailsservice.repository;

import com.filiaiev.userdetailsservice.repository.user.UserDetailsDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetailsDO, Long> {
}
