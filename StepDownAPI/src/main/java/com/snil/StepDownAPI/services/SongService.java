package com.snil.StepDownAPI.services;

import com.snil.StepDownAPI.entities.Song;
import com.snil.StepDownAPI.exceptions.SongException;
import com.snil.StepDownAPI.repositories.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class SongService {

    @Autowired
    private SongRepo songRepo;

    public Song getSong(long songId) throws SongException {
        try {
            return songRepo.findById(songId).orElseThrow(() -> new SongException("Can't find song with ID " + songId));
        } catch (Exception e) {
            throw new SongException("Can't get song: " + e.getMessage());
        }
    }

    public void addSong(Song song) throws SongException {
        try {
            songRepo.save(song);
        } catch (Exception e) {
            throw new SongException("Can't add song: " + e.getMessage());
        }
    }

    public List<Song> getAllSongs() throws SongException {
        try {
            return songRepo.findAll();
        } catch (Exception e) {
            throw new SongException("Can't get all songs: " + e.getMessage());
        }
    }

    public void deleteSong(long songId) throws SongException {
        try {
            if (songRepo.existsById(songId)) {
                songRepo.deleteById(songId);
            } else {
                throw new SongException("Can't find song with ID " + songId);
            }
        } catch (Exception e) {
            throw new SongException("Can't remove song: " + e.getMessage());
        }
    }
}
