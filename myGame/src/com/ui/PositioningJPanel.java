package com.ui;

import javax.swing.*;

public class PositioningJPanel extends JPanel {
    protected int posX;
    protected int posY;
    protected int wight;
    protected int height;
    public PositioningJPanel(){
        this.posX=0;
        this.posY=0;
    }

    public int getPosX(){
        return posX;
    }
    public int getPosY() {
        return posY;
    }

    public void setPosX(int x){
        posX=x;
    }
    public void setPosY(int y){
        posY=y;
    }

    public void setWH(int w, int h){
        wight=w;
        height=h;
    }
    public int getW(){
        return wight;
    }
    public int getH(){
        return height;
    }
}
