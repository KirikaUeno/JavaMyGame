package com.mapObjects;

public class InteractingRectangle {
    public double x;
    public double y;
    public double wight;
    public double height;

    public InteractingRectangle(double x, double y, double wight, double height){
        this.x=x;
        this.y=y;
        this.wight=wight;
        this.height=height;
    }

    public InteractingRectangle(InteractingRectangle rec){
        this.x=rec.x;
        this.y=rec.y;
        this.wight=rec.wight;
        this.height=rec.height;
    }

    public boolean isIntersect(InteractingRectangle b){
        if((b.y>(y+height)) || ((b.y+b.height)<y)){
            return false;
        }
        else if((b.x>(x+wight)) || ((b.x+b.wight)<x)){
            return false;
        }
        else return true;
    }
}
