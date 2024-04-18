package com.example.jpa.song.controller;

import com.example.jpa.InitData;
import com.example.jpa.song.dto.request.SongRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SongControllerTest  extends InitData {

    @Autowired private MockMvc mockMvc;
    String baseUrl = "/api/v1/songs";
    //    /api/v1/songs get  성공 : 200 obj
//    /api/v1/songs get  실패 : 200 빈 obj
    @Test
    void save() throws Exception  {
        //given
        ObjectMapper mapper = new ObjectMapper();
        SongRequest songRequest = new SongRequest("title1", "가사");
        String json = mapper.writeValueAsString(songRequest);
        //when & then

        mockMvc.perform(
                        post(baseUrl)
                                .content(json)
                ).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }


    @Test
    void getById() throws Exception {
//        given
        long id =song.getId();
//      when
        ResultActions perform = mockMvc.perform(
//                post("/api/v1/songs")
//                        .content("")
                get(baseUrl+"/" + id)
        );
//      then
        perform.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(song.getId()))
                .andExpect(jsonPath("$.title").value(song.getTitle()))
                .andExpect(jsonPath("$.lyrics").value(song.getLyrics()))
                .andExpect(jsonPath("$.createdAt").isNotEmpty())
        ;
    }
}