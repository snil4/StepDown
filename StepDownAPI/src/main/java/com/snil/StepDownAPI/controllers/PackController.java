package com.snil.StepDownAPI.controllers;

import com.snil.StepDownAPI.entities.Pack;
import com.snil.StepDownAPI.entities.Song;
import com.snil.StepDownAPI.exceptions.SongException;
import com.snil.StepDownAPI.services.PackService;
import com.snil.StepDownAPI.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/pack")
public class PackController {

    @Autowired
    PackService packService;

    @GetMapping("/{packId}")
    public ResponseEntity<Pack> getPack(@PathVariable long packId){
        try {
            Pack pack = packService.getPack(packId);
            return ResponseEntity.ok(pack);
        } catch (SongException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping()
    public ResponseEntity<Pack> addPack(@RequestBody Pack pack){
        try {
            pack = packService.addPack(pack);
            return ResponseEntity.ok(pack);
        } catch (SongException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<Pack> updatePack(@RequestBody Pack pack){
        try {
            pack = packService.updatePack(pack);
            return ResponseEntity.ok(pack);
        } catch (SongException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{packId}")
    public ResponseEntity<String> deletePack(@PathVariable long packId) {
        try {
            packService.deletePack(packId);
            return ResponseEntity.ok("deleted");
        } catch (SongException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pack>> getAllPacks(){
        try {
            return ResponseEntity.ok(packService.getAllPacks());
        } catch (SongException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
