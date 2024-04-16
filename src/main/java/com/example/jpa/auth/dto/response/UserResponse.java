package com.example.jpa.auth.dto.response;

import com.example.jpa.global.domain.dto.PlaylistDto;
import com.example.jpa.global.domain.dto.UserDto;
import com.example.jpa.global.domain.entity.Playlist;
import com.example.jpa.global.domain.entity.User;
import com.example.jpa.playlist.dto.response.PlaylistResponse;

import java.util.List;

public record UserResponse(Long id, String nickname, List<PlaylistDto> playlists) {
    public static UserResponse from(User user) {
        List<PlaylistDto> list = user.getPlaylists()
                .stream()
                .map(playlist -> new PlaylistDto(playlist.getId(), playlist.getTitle())).toList();

        return new UserResponse(user.getId(), user.getNickname(), list );
    }
}
