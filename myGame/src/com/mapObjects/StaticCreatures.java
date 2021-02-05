package com.mapObjects;

import javax.swing.*;

public class StaticCreatures extends StaticSprite {
    public StaticCreatures(ImageIcon sprite, double baseX, double baseY,double wight,double height){
        this.sprite=sprite;
        this.rectangle = new InteractingRectangle(baseX,baseY,wight,height);
    }
}