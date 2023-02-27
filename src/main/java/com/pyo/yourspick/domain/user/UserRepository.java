package com.pyo.yourspick.domain.user;

import com.pyo.yourspick.domain.image.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findByName(String name);

    @Query(value = "SELECT id, name, profileImageUrl FROM User", nativeQuery = true)
    List<UserInfoMapping> mFindUser();


    @Query(value = "SELECT * FROM User WHERE name LIKE CONCAT(:keyword,'%')", nativeQuery = true)
    List<User> mFindCaption(@Param("keyword") String keyword);


}
