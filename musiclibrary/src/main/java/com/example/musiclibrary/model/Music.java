package com.example.musiclibrary.model;

public class Music {
    private Long id;
    private String title;
    private double duration;
    private Long artistId;

    public Music() {}

    public Music(Long id, String title, double duration, Long artistId) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.artistId = artistId;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public double getDuration() { return duration; }
    public void setDuration(double duration) { this.duration = duration; }

    public Long getArtistId() { return artistId; }
    public void setArtistId(Long artistId) { this.artistId = artistId; }
}