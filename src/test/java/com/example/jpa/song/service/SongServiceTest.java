package com.example.jpa.song.service;

import com.example.jpa.global.domain.entity.Song;
import com.example.jpa.global.domain.repository.SongRepository;
import com.example.jpa.song.dto.request.SongRequest;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SongServiceTest {
    @Autowired
    private SongService songService;
    @Autowired
    private SongRepository songRepository;
    @Nested
    class update{
        @Test
        void 성공() {
            //given
            SongRequest req = new SongRequest("test1", "test1");
            Long id = song.getId();
            //when
            songService.update(req, id);
            //then
            Song song1 = songRepository.findById(song.getId()).get();
            Assertions.assertEquals("test1", song1.getTitle());
            Assertions.assertEquals("test1",song1.getLyrics());
        }
        @Test
        void 아이디가_없을_경우_실패() {
            //given
            SongRequest req = new SongRequest("test1", "test1");
            Long id = 10000L;
            //when & then
            Assertions.assertThrows(IllegalArgumentException.class,() -> songService.update(req, id));
        }
    }



    @Test
    void test2() {
        // given
        // when
        Song byId = songRepository.findById(song.getId()).get();

        // then
        Assertions.assertEquals(song, byId);
        Assertions.assertEquals(song.getId(), byId.getId());
        Assertions.assertEquals("test", byId.getTitle());

    }
    Song song;
    @BeforeEach
    void init(){
        song = new Song(null, "test", "test", LocalDateTime.now());
        songRepository.save(song);
    }

    @AfterEach
    void destroy(){
//        songRepository.deleteAll();
    }
}