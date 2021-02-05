package com.mapObjects;

import com.image.ImageFactory;
import com.image.Images;

import javax.swing.*;

public class NPS extends DynamicCreatures{
    private int i=0;

    public NPS(ImageIcon spriteLeft, ImageIcon spriteRight, double baseX, double baseY, double wight, double height) {
        super(spriteLeft, spriteRight, baseX, baseY, wight, height);
        speed = 4;
        this.spriteRight1= ImageFactory.createImage(Images.npsRight1);
        this.spriteRight2= ImageFactory.createImage(Images.npsRight2);
        this.spriteRight4= ImageFactory.createImage(Images.npsRight4);
        this.spriteLeft1= ImageFactory.createImage(Images.npsLeft1);
        this.spriteLeft2= ImageFactory.createImage(Images.npsLeft2);
        this.spriteLeft4= ImageFactory.createImage(Images.npsLeft4);
    }

    @Override
    public void move() {
        dy=0;
        if(i%200<100) {
            dx = speed;
            if(i%40<10){
                sprite=spriteRight1;
            }else if(i%40<20){
                sprite=spriteRight2;
            }else if(i%40<30){
                sprite=spriteRight1;
            }else{
                sprite=spriteRight4;
            }
        }
        else{
            dx = -speed;
            if(i%40<10){
                sprite=spriteLeft1;
            }else if(i%40<20){
                sprite=spriteLeft2;
            }else if(i%40<30){
                sprite=spriteLeft1;
            }else{
                sprite=spriteLeft4;
            }
        }
        rectangle.x+=dx;
        i++;
        if(i>199) i=0;
    }
}
