package com.snil.StepDownAPI.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String artist;
    private int bpm;
    @ManyToOne
    @JoinColumn(name = "uploader_id")
    private User uploader;
    @ElementCollection
    @CollectionTable
    private List<Chart> charts;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "song_vs_pack", joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "pack_id"))
    private List<Pack> packs;
    private boolean hasImage;

    public Song() {
    }

    public Song(long id, String title, String artist, int bpm, User uploader, List<Chart> charts, boolean hasImage) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
        this.uploader = uploader;
        this.charts = charts;
        this.hasImage = hasImage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getBpm() {
        return bpm;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }

    public User getUploader() {
        return uploader;
    }

    public void setUploader(User uploader) {
        this.uploader = uploader;
    }

    public List<Chart> getCharts() {
        return charts;
    }

    public void setCharts(List<Chart> charts) {
        this.charts = charts;
    }

    public boolean isHasImage() {
        return hasImage;
    }

    public void setHasImage(boolean hasImage) {
        this.hasImage = hasImage;
    }
}

@Embeddable
class Chart {
    private Difficulty difficulty;
    private int level;
    private String name;
    private String author;
}

enum Difficulty {
    BEGINNER, EASY, MEDIUM, HARD, EXPERT, EDIT
}
