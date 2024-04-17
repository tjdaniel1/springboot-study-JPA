package com.example.jpa.global.domain.repository;

import com.example.jpa.InitData;
import com.example.jpa.global.domain.entity.Playlist;
import com.example.jpa.global.domain.entity.User;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest extends InitData {

    @Test
    void findByUsername() {
        //given
        String username = "user1";
        //when
        List<User> byUserName = userRepository.findByUsername(username);
        //then
        Assertions.assertEquals(1, byUserName.size());

    }

    @Test
    void findByNicknameContainingOrderByIdDesc() {
        //given
        String username = "user";
        //when
        List<User> users = userRepository.findByNicknameContainingOrderByIdDesc(username);
        //then
        Assertions.assertEquals(10,users.size());
        Assertions.assertEquals("user9", users.get(0).getNickname());
    }
}