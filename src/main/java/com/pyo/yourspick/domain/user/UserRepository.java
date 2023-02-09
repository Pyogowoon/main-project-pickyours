package com.pyo.yourspick.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    @Query(value = "SELECT id, name, profileImageUrl FROM user", nativeQuery = true)
    List<UserInfoMapping> mFindUser();
}
