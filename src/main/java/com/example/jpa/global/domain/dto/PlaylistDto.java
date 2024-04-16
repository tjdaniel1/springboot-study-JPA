package com.example.jpa.global.domain.dto;

import com.example.jpa.global.domain.entity.User;
import jakarta.persistence.*;

public record PlaylistDto(
         Long id,
         String title
) {
}
