package com.yooohaozx.yooohao.photoz.clone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackageName:photoz-clone
 * @ClassName: PhotoController
 * Description:
 * @author: ZIHAO
 * @date 2023-03-02 22:26
 */
@RestController
public class PhotoController {

    @GetMapping("/")
    public String hello(){
        return "Hello world";
    }
}
