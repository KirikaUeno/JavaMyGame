package com.objects;

import com.image.ImageFactory;

import java.awt.*;

public abstract class Sprite {
    private Image imageHead;
    private Image imageBody;
    private boolean dead;
    private Skin skin;

    protected int x;
    protected int y;

    public abstract void move();

    public Sprite(){
        this.dead=false;
    }

    public void die(){
        this.dead=true;
    }

    public void setSkin(Skin skin){
        this.skin=skin;

    }

    public Skin getSkin(){
        return this.skin;
    }

    public void setX(int x){
        this.x=x;
    }

    public void setY(int y){
        this.y=y;
    }

    public int getY(){
        return this.y;
    }

    public int getX(){
        return this.x;
    }

    public boolean isDead(){
        return this.dead;
    }
}
