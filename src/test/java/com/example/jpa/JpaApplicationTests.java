package com.example.jpa;

import com.example.jpa.global.domain.entity.Playlist;
import com.example.jpa.global.domain.entity.User;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JpaApplicationTests extends InitData{

	@Autowired
	EntityManager em;

	@Test
	void contextLoads() {

	}
	@Test
	void N_PLUS_1(){
		em.flush();
		em.clear();
		List<User> all = userRepository.findAll();
		for(User user : all){
			System.out.println("Start");
			System.out.println(user.getPlaylists().get(0).getTitle());
		}
	}

	@Test
	void N_PLUS_2() {
		List<Playlist> all = playlistRepository.findAll();
		for(Playlist playlist : all){
			System.out.println("Start");
			System.out.println(playlist.getUser().getUsername());
		}
	}

	@Test
	void joinTest(){
		//given
		List<Playlist> allWithUsers = playlistRepository.findAllWithUsers("1");
		allWithUsers.forEach(
				playlist -> {
					System.out.println(playlist.getTitle());
					System.out.println(playlist.getId());
					System.out.println(playlist.getUser().getUsername());
				}
		);
		//when

		//then

	}

}
