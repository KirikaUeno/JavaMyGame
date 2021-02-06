package com.mapObjects;

import com.image.Images;
import com.image.ImageFactory;

import javax.swing.*;

public class Skin {
    private final String skinName;
    private final Images headImage;
    private final Images bodyImage;
    public ImageIcon headimage;
    public ImageIcon bodyimage;

    public Skin(String name, Images head, Images body){
        skinName=name;
        headImage =head;
        bodyImage =body;
        this.bodyimage= ImageFactory.createImage(bodyImage);
        this.headimage= ImageFactory.createImage(headImage);
    }

    public ImageIcon getImageHead(){
        return this.headimage;
    }
    public ImageIcon getImageBody(){
        return this.bodyimage;
    }
}
