package com.example.musiclibrary.repository;

import com.example.musiclibrary.db.DatabaseConnection;
import com.example.musiclibrary.model.Music;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MusicRepository {
    public List<Music> getAllMusic() throws SQLException {
        List<Music> musicList = new ArrayList<>();
        String sql = "SELECT * FROM music";
        try (Connection connection = DatabaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                musicList.add(new Music(rs.getLong("id"), rs.getString("title"),
                        rs.getInt("duration"), rs.getLong("artist_id")));
            }
        }
        return musicList;
    }

    public void saveMusic(Music music) throws SQLException {
        String sql = "INSERT INTO music (title, duration, artist_id) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, music.getTitle());
            stmt.setDouble(2, music.getDuration());
            stmt.setLong(3, music.getArtistId());
            stmt.executeUpdate();
        }
    }

    public void deleteMusic(Long id) throws SQLException {
        String sql = "DELETE FROM music WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}