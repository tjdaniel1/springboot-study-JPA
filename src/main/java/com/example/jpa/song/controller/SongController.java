package com.example.jpa.song.controller;

import com.example.jpa.global.domain.entity.Playlist;
import com.example.jpa.global.domain.entity.Song;
import com.example.jpa.song.dto.request.SongRequest;
import com.example.jpa.song.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/songs")
@RequiredArgsConstructor
public class SongController {
    private final SongService songService;
    @GetMapping
    public List<Song> getAll(){
        return songService.getAll();
    }
    @PostMapping
    public void save(@RequestBody SongRequest req){
        songService.save(req);

    }
    @GetMapping("/{id}")
    public Song getById(@PathVariable("id") Long id){
        Playlist p = new Playlist();
        return songService.getById(id);
    }
}