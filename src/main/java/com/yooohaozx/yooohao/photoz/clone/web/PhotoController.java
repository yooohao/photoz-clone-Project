package com.yooohaozx.yooohao.photoz.clone.web;

import com.yooohaozx.yooohao.photoz.clone.model.Photo;
import com.yooohaozx.yooohao.photoz.clone.service.PhotoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

/**
 * @PackageName:photoz-clone
 * @ClassName: PhotoController
 * Description:
 * @author: ZIHAO
 * @date 2023-03-02 22:26
 */
@RestController
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    //    private List<Photo> dataBase = List.of(new Photo("1","hello.jpg"));

    @GetMapping("/")
    public String hello(){
        return "Hello world";
    }

    @GetMapping("/photoz")
    public Iterable<Photo> get(){
        return photoService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable Integer id){
        Photo photo = photoService.get(id);
        if (photo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable Integer id){
        photoService.remove(id);
    }

    @PostMapping("/photoz")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {

        Photo photo = photoService.save(file.getOriginalFilename(),file.getContentType(),file.getBytes());
        return photo;
    }

}
