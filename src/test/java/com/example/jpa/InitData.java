package com.example.jpa;

import com.example.jpa.global.domain.entity.Playlist;
import com.example.jpa.global.domain.entity.Song;
import com.example.jpa.global.domain.entity.User;
import com.example.jpa.global.domain.repository.PlaylistRepository;
import com.example.jpa.global.domain.repository.SongRepository;
import com.example.jpa.global.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@Transactional
public class InitData {
    @Autowired protected PlaylistRepository playlistRepository;
    @Autowired protected UserRepository userRepository;
    @Autowired protected SongRepository songRepository;
    protected Song song;
    @BeforeEach
    void init(){
        song = Song.builder()
                .title("song")
                .lyrics("song")
                .createdAt(LocalDateTime.now())
                .build();
        songRepository.save(song);
        for(int i=0; i<10; i++){
            User user = new User(null,
                    "user" + i,
                    "user" + i,
                    "user" + i,
                    null);
            userRepository.save(user);
            List<Playlist> playlistList = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                Playlist playlist = new Playlist(
                        null, "title"+j, user
                );
                playlistList.add(playlist);
            }
            playlistRepository.saveAll(playlistList);
        }
    }
}