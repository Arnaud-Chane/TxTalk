package com.txtalk.chat.model.repository.user;

import com.txtalk.chat.model.entity.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    @Query(value = "SELECT * FROM user", nativeQuery = true)
    List<UserModel> findAllUsers();

    @Query(value = "SELECT COUNT(*)\n" +
            "FROM txtalk_db.user", nativeQuery = true)
    Integer countAllUsers();

    @Query(value = "SELECT * FROM user u WHERE u.email = ?1", nativeQuery = true)
    UserModel findUserByEmail(String email);

//    @Query("SELECT u FROM UserModel u WHERE u.email = ?1")
//    UserModel findUserByEmail(String email);

    @Query(value = "SELECT * FROM user u WHERE u.nickname = ?1", nativeQuery = true)
    UserModel findUserByNickname(String nickname);

    Optional<UserModel> findByEmail(String email);
}
