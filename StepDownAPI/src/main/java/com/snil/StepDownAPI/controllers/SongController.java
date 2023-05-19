package com.snil.StepDownAPI.controllers;

import com.snil.StepDownAPI.entities.Song;
import com.snil.StepDownAPI.exceptions.SongException;
import com.snil.StepDownAPI.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/song")
public class SongController {

    @Autowired
    SongService songService;

    @GetMapping("/{songId}")
    public ResponseEntity<Song> getSong(@PathVariable long songId){
        try {
            Song song = songService.getSong(songId);
            return ResponseEntity.ok(song);
        } catch (SongException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<Song> addSong(@RequestBody Song song){
        try {
            song = songService.addSong(song);
            return ResponseEntity.ok(song);
        } catch (SongException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<Song> updateSong(@RequestBody Song song){
        try {
            song = songService.updateSong(song);
            return ResponseEntity.ok(song);
        } catch (SongException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{songId}")
    public ResponseEntity<String> deleteSong(@PathVariable long songId) {
        try {
            songService.deleteSong(songId);
            return ResponseEntity.ok("deleted");
        } catch (SongException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Song>> getAllSongs(){
        try {
            return ResponseEntity.ok(songService.getAllSongs());
        } catch (SongException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
