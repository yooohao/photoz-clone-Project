package com.yooohaozx.yooohao.photoz.clone.service;

import com.yooohaozx.yooohao.photoz.clone.model.Photo;
import com.yooohaozx.yooohao.photoz.clone.repository.PhotozRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @PackageName:photoz-clone
 * @ClassName: PhotoService
 * Description:
 * @author: ZIHAO
 * @date 2023-03-06 19:07
 */
//@Component
@Service
public class PhotoService {

    private final PhotozRepository photozRepository;

    public PhotoService(PhotozRepository photozRepository) {
        this.photozRepository = photozRepository;
    }

    public Iterable<Photo> get() {
        return photozRepository.findAll();
    }

    public Photo get(Integer id) {
        return photozRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photozRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setData(data);
        photozRepository.save(photo);
        return photo;
    }
}
