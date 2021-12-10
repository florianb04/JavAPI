package com.example.javapi.repository;

import com.example.javapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //SELECT * FROM user WHERE email = ?
    @Query("SELECT s FROM User s WHERE s.email_user = ?1")
    Optional<User> findUserByEmail_user(String email_user);
}
