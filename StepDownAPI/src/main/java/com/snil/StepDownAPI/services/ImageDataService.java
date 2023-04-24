package com.snil.StepDownAPI.services;

import com.snil.StepDownAPI.exceptions.ImageException;
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
    public ImageData getInfoByImageByName(String name) throws ImageException {
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

class ImageData {

    private Long id;
    private String name;
    private String type;
    private byte[] imageData;

    public ImageData() {
    }

    public ImageData(Long id, String name, String type, byte[] imageData) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.imageData = imageData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}

