package com.mapObjects;

public abstract class DynamicSprite {
    protected double dx;
    protected double dy;
    protected double speed;
    protected InteractingRectangle rectangle;

    public abstract void move();

    public int getY(){
        return (int)this.rectangle.y;
    }
    public int getX(){
        return (int)this.rectangle.x;
    }
    public int getDx(){
        return (int)this.dx;
    }
    public int getDy(){
        return (int)this.dy;
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
