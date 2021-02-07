package com.maps;

public class Node {
    public int i;
    public int j;
    public int value;
    public int g;
    public int f;
    public Node cameFrom;

    public Node(int i, int j){
        this.i=i;
        this.j=j;
        value=1;
        int inf = 100000;
        g= inf;
        f= inf;
        cameFrom=null;
    }

    @Override
    public String toString(){
        return (i+" "+j);
    }
}
