package com.snil.StepDownAPI.services;

import com.snil.StepDownAPI.data.ImageData;
import com.snil.StepDownAPI.exceptions.ImageException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Transactional
public class ImageDataService {

    /**
     * @param file The image to upload
     * @return The file's final name
     */
    public String uploadImage(MultipartFile file) throws ImageException {
        String fileName = file.getOriginalFilename();
        try {

            Path path = Path.of("assets/images/" + fileName);
            File newFile = path.toFile();
            newFile.getParentFile().mkdirs();
            path.toFile().createNewFile();
            Files.write(path, file.getBytes());
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ImageException("Can't upload image: " + e.getMessage(), e);
        }

    }

    /**
     * @param name The image file's name
     * @return the imageData object
     */
    public ImageData getInfoByImageName(String name) throws ImageException {
        try {
            if (!name.equals("")) {
                String[] splitName = name.split("[.]");
                String fileType = splitName[splitName.length - 1];
                return new ImageData(0L, name, "image/" + fileType,
                        Files.readAllBytes(Paths.get("assets/images/" + name)));
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new ImageException("Can't get info: " + e.getMessage(), e);
        }
    }

    /**
     * @param name - The name of the image file
     * @return - The image file's bytes array
     */
    public byte[] getImage(String name) throws ImageException {
        try {
            if (!name.equals("")) {
                return Files.readAllBytes(Paths.get("assets/images/" + name));
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new ImageException("Can't get image: " + e.getMessage(), e);
        }
    }

}

