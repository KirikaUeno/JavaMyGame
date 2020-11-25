package com.objects;

import com.company.Constants;
import com.image.ImageFactory;
import com.image.Image;

import javax.swing.*;
import java.awt.event.KeyEvent;


public class Personas extends Sprite{
    private int leftpressed;
    private int rightpressed;
    private int uppressed;
    private int downpressed;
    private Skin skin;
    public Personas(){
        initialize();
    }

    private void initialize() {
        this.skin = Constants.first;
        setSkin(skin);

        int start_x= Constants.boardWight/2-Constants.GIRLWight/2;
        int start_y= Constants.boardHeight/2-Constants.GIRLHeight/2;
        setX(start_x);
        setY(start_y);
    }

    @Override
    public void move() {
        x += 2*(rightpressed-leftpressed);

        y += 2*(-uppressed+downpressed);
        if(x<0){
            x=0;
        }
        if(y<0){
            y=0;
        }
        if(x>(Constants.boardWight-Constants.GIRLWight)){
            x=Constants.boardWight-Constants.GIRLWight;
        }
        if(y>(Constants.boardHeight-2*Constants.GIRLHeight)){
            y=Constants.boardHeight-2*Constants.GIRLHeight;
        }
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key==KeyEvent.VK_LEFT){
            leftpressed=1;
        }
        if(key==KeyEvent.VK_RIGHT){
            rightpressed=1;
        }
        if(key==KeyEvent.VK_UP){
            uppressed=1;
        }
        if(key==KeyEvent.VK_DOWN){
            downpressed=1;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key==KeyEvent.VK_LEFT){
            leftpressed=0;
        }
        if(key==KeyEvent.VK_RIGHT){
            rightpressed=0;
        }
        if(key==KeyEvent.VK_UP){
            uppressed=0;
        }
        if(key==KeyEvent.VK_DOWN){
            downpressed=0;
        }
    }

    public void button1(){
        setSkin(Constants.first);
    }
    public void button2(){
        setSkin(Constants.second);
    }
    public void button3(){
        setSkin(Constants.second);
    }
    public void button4(){
        setSkin(Constants.second);
    }
    public void button5(){
        setSkin(Constants.second);
    }
    public void button6(){
        setSkin(Constants.second);
    }
}
