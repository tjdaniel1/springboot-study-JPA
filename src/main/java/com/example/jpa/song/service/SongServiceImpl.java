package com.example.jpa.song.service;

import com.example.jpa.global.domain.entity.Song;
import com.example.jpa.global.domain.repository.SongRepository;
import com.example.jpa.song.dto.request.SongRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService{
    private final SongRepository songRepository;
    @Override
    public void save(SongRequest req) {
        songRepository.save(req.toEntity());
    }

    @Override
    public List<Song> getAll() {
        return songRepository.findAll();
    }

    @Override
    public Song getById(Long id) {
        Optional<Song> byId = songRepository.findById(id);
        return byId.orElse(new Song());
//        if(byId.isEmpty()) return null;
//        return byId.get();
    }
}