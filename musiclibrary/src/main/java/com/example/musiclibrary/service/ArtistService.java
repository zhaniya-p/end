package com.example.musiclibrary.service;

import com.example.musiclibrary.model.Artist;
import com.example.musiclibrary.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> getAllArtists() throws SQLException {
        return artistRepository.getAllArtists();
    }

    public void createArtist(Artist artist) throws SQLException {
        artistRepository.saveArtist(artist);
    }

    public void deleteArtist(Long id) throws SQLException {
        artistRepository.deleteArtist(id);
    }
}