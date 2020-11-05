package com.app.twitter.repository;

import com.app.twitter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u From User u WHERE u.email = ?1")
    User findByEmail(String email);
}
