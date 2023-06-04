package com.filmboard.assignment.repository;

import com.filmboard.assignment.enitity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, UUID> {

    Optional<UserDetails> findByUsername(String user_name);
}
