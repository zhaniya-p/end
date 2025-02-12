package com.example.musiclibrary.controller;

import com.example.musiclibrary.model.Music;
import com.example.musiclibrary.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/music")
public class MusicController {
    private final MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping
    public List<Music> getAllMusic() throws SQLException {
        return musicService.getAllMusic();
    }

    @PostMapping
    public String createMusic(@RequestBody Music music) throws SQLException {
        musicService.createMusic(music);
        return "Music created!";
    }

    @DeleteMapping("/{id}")
    public String deleteMusic(@PathVariable Long id) throws SQLException {
        musicService.deleteMusic(id);
        return "Music deleted!";
    }
}