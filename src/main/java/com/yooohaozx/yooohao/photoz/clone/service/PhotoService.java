package com.yooohaozx.yooohao.photoz.clone.service;

import com.yooohaozx.yooohao.photoz.clone.model.Photo;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @PackageName:photoz-clone
 * @ClassName: PhotoService
 * Description:
 * @author: ZIHAO
 * @date 2023-03-06 19:07
 */
@Component
//@Service
public class PhotoService {

    private Map<String, Photo> dataBase = new HashMap<>(){{
        put("1",new Photo("1","hello.jpg"));
    }};

    public Collection<Photo> get() {
        return dataBase.values();
    }

    public Photo get(String id) {
        return dataBase.get(id);
    }

    public Photo remove(String id) {
        return dataBase.remove(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(fileName);
        photo.setData(data);
        dataBase.put(photo.getId(), photo);
        return photo;
    }
}
