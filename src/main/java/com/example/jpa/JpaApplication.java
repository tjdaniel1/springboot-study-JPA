package com.example.jpa;

import com.example.jpa.global.domain.entity.User;
import com.example.jpa.global.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@SpringBootApplication
public class JpaApplication {
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
}

