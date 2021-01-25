package com.sda.spring.boot.rest.autowired;

public class ImageConverter implements IImageConverter {

    @Override
    public void convertImage() {
        System.out.println("converting");
    }
}
