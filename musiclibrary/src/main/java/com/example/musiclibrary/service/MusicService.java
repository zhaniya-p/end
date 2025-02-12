package com.example.musiclibrary.service;

import com.example.musiclibrary.model.Music;
import com.example.musiclibrary.repository.MusicRepository;
import java.sql.SQLException;
import java.util.List;

public class MusicService {
    private final MusicRepository musicRepository;

    public MusicService(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public List<Music> getAllMusic() throws SQLException {
        return musicRepository.getAllMusic();
    }

    public void createMusic(Music music) throws SQLException {
        musicRepository.saveMusic(music);
    }

    public void deleteMusic(Long id) throws SQLException {
        musicRepository.deleteMusic(id);
    }
}