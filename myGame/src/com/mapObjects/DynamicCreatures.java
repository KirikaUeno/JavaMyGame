package com.mapObjects;

import javax.swing.*;

public class DynamicCreatures extends DynamicSprite{
    protected ImageIcon spriteUp;
    protected ImageIcon spriteDown;
    protected ImageIcon spriteLeft1;
    protected ImageIcon spriteRight1;
    protected ImageIcon spriteLeft2;
    protected ImageIcon spriteRight2;
    protected ImageIcon spriteLeft4;
    protected ImageIcon spriteRight4;
    protected ImageIcon sprite;

    public DynamicCreatures(ImageIcon spriteLeft,ImageIcon spriteRight, double baseX, double baseY,double wight,double height){
        this.rectangle = new InteractingRectangle(baseX,baseY,wight,height);
        this.sprite=spriteLeft;
    }

    public ImageIcon getSprite(){
        return sprite;
    }

    @Override
    public void move() {
    }
}
