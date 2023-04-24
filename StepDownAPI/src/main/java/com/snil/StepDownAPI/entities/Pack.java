package com.snil.StepDownAPI.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "uploader_id")
    private User uploader;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "song_vs_pack", joinColumns = @JoinColumn(name = "pack_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id"))
    private List<Song> songs;
    private boolean hasImage;

    public Pack() {
    }

    public Pack(long id, String name, User uploader, List<Song> songs, boolean hasImage) {
        this.id = id;
        this.name = name;
        this.uploader = uploader;
        this.songs = songs;
        this.hasImage = hasImage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUploader() {
        return uploader;
    }

    public void setUploader(User uploader) {
        this.uploader = uploader;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public boolean isHasImage() {
        return hasImage;
    }

    public void setHasImage(boolean hasImage) {
        this.hasImage = hasImage;
    }
}
