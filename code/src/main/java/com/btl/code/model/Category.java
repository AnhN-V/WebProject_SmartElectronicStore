package com.btl.code.model;

import java.io.Serializable;

public class Category implements Serializable {

    private int id;

    private String name;

    private String imgPath;

    public Category(int id, String name,String imgPath) {
        this.id = id;
        this.name = name;
        this.imgPath = imgPath;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
