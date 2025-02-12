package com.example.musiclibrary.controller;

import com.example.musiclibrary.model.Artist;
import com.example.musiclibrary.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public List<Artist> getAllArtists() throws SQLException {
        return artistService.getAllArtists();
    }

    @PostMapping
    public String createArtist(@RequestBody Artist artist) throws SQLException {
        artistService.createArtist(artist);
        return "Artist created!";
    }

    @DeleteMapping("/{id}")
    public String deleteArtist(@PathVariable Long id) throws SQLException {
        artistService.deleteArtist(id);
        return "Artist deleted!";
    }
}