package com.mapObjects;

import com.company.Constants;
import com.image.ImageFactory;
import com.image.Images;

import javax.swing.*;

public class Player extends DynamicSprite {
    private final Skin skin;
    private final int[] pressedButtons = new int[4];
    private final int i=0;
    protected ImageIcon spriteLeft1;
    protected ImageIcon spriteRight1;
    protected ImageIcon spriteLeft2;
    protected ImageIcon spriteRight2;
    protected ImageIcon spriteLeft4;
    protected ImageIcon spriteRight4;
    protected ImageIcon spriteStay0;

    public Player(){
        skin = new Skin("basic", Images.SKIN1,Images.SKIN2);
        rectangle = new InteractingRectangle(Constants.boardWight/2.0-Constants.girlWight /2.0, Constants.boardHeight/2.0-Constants.girlHeight /2.0, Constants.girlWight, Constants.girlHeight);
        this.spriteRight1= ImageFactory.createImage(Images.npsRight1);
        this.spriteRight2= ImageFactory.createImage(Images.npsRight2);
        this.spriteRight4= ImageFactory.createImage(Images.npsRight4);
        this.spriteLeft1= ImageFactory.createImage(Images.npsLeft1);
        this.spriteLeft2= ImageFactory.createImage(Images.npsLeft2);
        this.spriteLeft4= ImageFactory.createImage(Images.npsLeft4);
        this.spriteStay0 = ImageFactory.createImage(Images.SKIN1);
    }

    @Override
    public void move() {
        dx = (pressedButtons[3] - pressedButtons[1]);
        dy = (pressedButtons[2] - pressedButtons[0]);
        if(dx!=0 || dy!=0) {
            double dx1 = dx / Math.sqrt(dx * dx + dy * dy);
            double dy1 = dy / Math.sqrt(dx * dx + dy * dy);
            dx = dx1*speed;
            dy = dy1*speed;
            rectangle.x += dx;
            rectangle.y += dy;
        }
        /*if(dx>0) {
            if(i%40<10){
                skin.headimage=spriteRight1;
            }else if(i%40<20){
                skin.headimage=spriteRight2;
            }else if(i%40<30){
                skin.headimage=spriteRight1;
            }else{
                skin.headimage=spriteRight4;
            }
        } else if(dx==0) skin.headimage=spriteStay0;
        else{
            if(i%40<10){
                skin.headimage=spriteLeft1;
            }else if(i%40<20){
                skin.headimage=spriteLeft2;
            }else if(i%40<30){
                skin.headimage=spriteLeft1;
            }else{
                skin.headimage=spriteLeft4;
            }
        }
        i++;
        if(i>199) i=0;*/
    }

    public Skin getSkin() {
        return skin;
    }

    public void setPressedButtons(int index, boolean pressed,int shift) {
        if(pressed) this.pressedButtons[index] = 1;
        else this.pressedButtons[index] = 0;
        if(shift==1) speed = 5;
        else speed = 2;
    }

    public int[] getPressedButtons() {
        return pressedButtons;
    }
}
