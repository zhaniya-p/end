package com.example.musiclibrary;

import com.example.musiclibrary.repository.ArtistRepository;
import com.example.musiclibrary.repository.MusicRepository;
import com.example.musiclibrary.service.ArtistService;
import com.example.musiclibrary.service.MusicService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class MusicLibraryApplication {
	public static void main(String[] args) {
		SpringApplication.run(MusicLibraryApplication.class, args);
		try {
			Connection connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/music_library",
					"postgres",
					"z050311"
			);

			ArtistRepository artistRepository = new ArtistRepository(connection);
			MusicRepository musicRepository = new MusicRepository();
			ArtistService artistService = new ArtistService(artistRepository);
			MusicService musicService = new MusicService(musicRepository);

			System.out.println("Connected to PostgreSQL database!");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}