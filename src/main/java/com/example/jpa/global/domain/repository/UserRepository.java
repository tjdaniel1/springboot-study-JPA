package com.example.jpa.global.domain.repository;

import com.example.jpa.global.domain.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository
        extends JpaRepository<User, Long> {
    //select * from users where user_name = ?
    List<User> findByUsername(String username);
    //select * from users where user_nickname likee "%?%"
    //order by userId desc
    List<User> findByNicknameContainingOrderByIdDesc(String nickname);
}
