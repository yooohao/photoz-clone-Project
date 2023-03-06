package com.yooohaozx.yooohao.photoz.clone;

import jakarta.validation.Valid;
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
    private Map<String, Photo> dataBase = new HashMap<>(){{
        put("1",new Photo("1","hello.jpg"));
    }};
//    private List<Photo> dataBase = List.of(new Photo("1","hello.jpg"));

    @GetMapping("/")
    public String hello(){
        return "Hello world";
    }

    @GetMapping("/photoz")
    public Collection<Photo> get(){
        return dataBase.values();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable String id){
        Photo photo = dataBase.get(id);
        if (photo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable String id){
        Photo photo = dataBase.remove(id);
        if (photo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/photoz")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        Photo photo = new Photo();
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(file.getOriginalFilename());
        photo.setData(file.getBytes());
        dataBase.put(photo.getId(), photo);
        return photo;
    }

}
