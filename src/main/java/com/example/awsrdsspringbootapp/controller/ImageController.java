package com.example.awsrdsspringbootapp.controller;


import com.example.awsrdsspringbootapp.clientmodel.ImageUploadClientModel;
import com.example.awsrdsspringbootapp.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        return imageService.findAll();
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@ModelAttribute ImageUploadClientModel downloadClientModel) {
        return imageService.upload(downloadClientModel);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<?> delete(@PathVariable String name) {
        return imageService.delete(name);
    }

    @GetMapping("/get-random")
    public ResponseEntity<?> getRandomImage() {
        return imageService.getRandom();
    }

    @GetMapping(value = "/download/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] download(@PathVariable String name) {
        return imageService.getImage(name);
    }
}
