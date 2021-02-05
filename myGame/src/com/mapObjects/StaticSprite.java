package com.mapObjects;

import javax.swing.*;

public abstract class StaticSprite {
    protected InteractingRectangle rectangle;

    protected ImageIcon sprite;

    public int getY(){
        return (int)this.rectangle.y;
    }
    public int getX(){
        return (int)this.rectangle.x;
    }

    public ImageIcon getSprite() {
        return sprite;
    }

    public double getWight() {
        return this.rectangle.wight;
    }
    public double getHeight() {
        return this.rectangle.height;
    }

    public InteractingRectangle getRectangle(){
        return rectangle;
    }
    public void setRectangle(InteractingRectangle rec){
        rectangle=rec;
    }
}
