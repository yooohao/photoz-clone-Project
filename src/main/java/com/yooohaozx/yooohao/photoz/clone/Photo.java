package com.yooohaozx.yooohao.photoz.clone;

/**
 * @PackageName:photoz-clone
 * @ClassName: Photo
 * Description:
 * @author: ZIHAO
 * @date 2023-03-02 22:30
 */
public class Photo {
    private String id;
    private String fileName;

    public Photo() {
    }

    public Photo(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    //raw data

    public String getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
