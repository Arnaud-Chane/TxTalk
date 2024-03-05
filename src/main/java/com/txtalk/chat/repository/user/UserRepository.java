package com.txtalk.chat.repository.user;

import com.txtalk.chat.model.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    Optional<UserModel> findByEmail(String email);

    @Query(value = "SELECT * FROM users", nativeQuery = true)
    List<UserModel> findAllUsers();
}
