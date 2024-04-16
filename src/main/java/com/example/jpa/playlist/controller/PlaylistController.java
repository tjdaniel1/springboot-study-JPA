package com.example.jpa.playlist.controller;

import com.example.jpa.global.domain.entity.Playlist;
import com.example.jpa.playlist.dto.request.PlaylistRequest;
import com.example.jpa.playlist.dto.response.PlaylistResponse;
import com.example.jpa.playlist.service.PlaylistService;
import com.example.jpa.song.dto.request.SongRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/playlists")
public class PlaylistController {
    private final PlaylistService playlistService;

    @GetMapping
    public List<PlaylistResponse> getAll() {
        return playlistService.getAll();
    }

    @PostMapping
    public void save(@RequestBody PlaylistRequest req) {
        playlistService.save(req);
    }
}
