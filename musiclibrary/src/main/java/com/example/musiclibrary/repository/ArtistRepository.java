package com.example.musiclibrary.repository;

import com.example.musiclibrary.model.Artist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArtistRepository {

    private final DataSource dataSource;

    @Autowired
    public ArtistRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Artist> getAllArtists() throws SQLException {
        List<Artist> artists = new ArrayList<>();
        String sql = "SELECT * FROM artists";

        try (Connection connection = dataSource.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                artists.add(new Artist(rs.getLong("id"), rs.getString("name"), rs.getString("genre")));
            }
        }
        return artists;
    }

    public void saveArtist(Artist artist) throws SQLException {
        String sql = "INSERT INTO artists (name, genre) VALUES (?, ?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, artist.getName());
            stmt.setString(2, artist.getGenre());
            stmt.executeUpdate();
        }
    }

    public void deleteArtist(Long id) throws SQLException {
        String sql = "DELETE FROM artists WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}