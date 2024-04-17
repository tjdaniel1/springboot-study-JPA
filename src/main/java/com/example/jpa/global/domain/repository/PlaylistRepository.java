package com.example.jpa.global.domain.repository;

import com.example.jpa.global.domain.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    //named query
    List<Playlist> findByTitle(String title);

}
