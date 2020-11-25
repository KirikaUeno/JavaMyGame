package com.objects;

import com.image.Image;
import com.image.ImageFactory;

public class Skin {
    private String skinName;
    private Image headImage;
    private Image bodyImage;
    private java.awt.Image headimage;
    private java.awt.Image bodyimage;

    public Skin(String name, Image head, Image body){
        skinName=name;
        headImage=head;
        bodyImage=body;
        this.bodyimage= ImageFactory.createImage(bodyImage).getImage();
        this.headimage= ImageFactory.createImage(headImage).getImage();
    }

    public java.awt.Image getImageHead(){
        return this.headimage;
    }
    public java.awt.Image getImageBody(){
        return this.bodyimage;
    }
}
