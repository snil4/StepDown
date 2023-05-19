package com.snil.StepDownAPI.controllers;

import com.snil.StepDownAPI.exceptions.ImageException;
import com.snil.StepDownAPI.data.ImageData;
import com.snil.StepDownAPI.services.ImageDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/image")
@Transactional
@CrossOrigin
public class ImageDataController {

    @Autowired
    private ImageDataService imageDataService;

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(imageDataService.uploadImage(file));
        } catch (ImageException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/info/{name}")
    public ResponseEntity<ImageData> getImageInfoByName(@PathVariable("name") String name){
        try {
            ImageData image = imageDataService.getInfoByImageName(name);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(image);
        } catch (ImageException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<byte[]>  getImageByName(@PathVariable("name") String name){
        try {
            byte[] image = imageDataService.getImage(name);

            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.valueOf(imageDataService.getInfoByImageName(name).getType()))
                    .body(image);
        } catch (ImageException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
