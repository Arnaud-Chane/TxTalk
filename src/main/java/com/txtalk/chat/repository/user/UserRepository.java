package com.txtalk.chat.repository.user;

import com.txtalk.chat.model.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    @Query(value = "SELECT * FROM user", nativeQuery = true)
    List<UserModel> findAllUsers();

    @Query(value = "SELECT * FROM user u WHERE u.email = ?1", nativeQuery = true)
    UserModel findUserByEmail(String email);
}
