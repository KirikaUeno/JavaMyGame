package com.maps;

import com.company.Constants;
import com.mapObjects.DynamicCreatures;
import com.mapObjects.InteractingRectangle;
import com.mapObjects.Player;
import com.mapObjects.StaticCreatures;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class Maps {
    public ArrayList<StaticCreatures> staticTerrain;
    public ArrayList<DynamicCreatures> dynamicTerrain;
    public Player player;
    public ImageIcon background;

    public Maps(Player player, ArrayList<StaticCreatures> staticTerrain, ArrayList<DynamicCreatures> dynamicTerrain, ImageIcon background){
        this.staticTerrain=staticTerrain;
        this.dynamicTerrain=dynamicTerrain;
        this.player=player;
        this.background=background;
        fixStartingPositions();
    }

    public void update(){
        this.player.move();
        for(DynamicCreatures dyn: dynamicTerrain){
            dyn.move();
        }
        fixStartingPositions();
    }

    private void resetDynamics() {
        ArrayList<Boolean> wasReseted = new ArrayList<>();
        wasReseted.add(false);
        for(int i=0;i<dynamicTerrain.size();i++){
            wasReseted.add(false);
        }
        InteractingRectangle pr = player.getRectangle();
        for(int i = 0; i<dynamicTerrain.size();i++) {
            if(!wasReseted.get(i+1)) {
                InteractingRectangle dr = dynamicTerrain.get(i).getRectangle();
                for (int j = i + 1; j < dynamicTerrain.size(); j++) {
                    InteractingRectangle sr = dynamicTerrain.get(j).getRectangle();
                    if (dr.isIntersect(sr)) {
                        dr.x -= dynamicTerrain.get(i).getDx();
                        dr.y -= dynamicTerrain.get(i).getDy();
                        sr.x -= dynamicTerrain.get(j).getDx();
                        sr.y -= dynamicTerrain.get(j).getDy();
                        wasReseted.set(i+1, true);
                        wasReseted.set(j+1, true);
                    }
                }
            }
        }
        for(int i = 0; i<dynamicTerrain.size();i++) {
            if(!wasReseted.get(1)) {
                InteractingRectangle dr = dynamicTerrain.get(i).getRectangle();
                if (dr.isIntersect(pr)) {
                    if(!wasReseted.get(i+1)) {
                        dr.x -= dynamicTerrain.get(i).getDx();
                        dr.y -= dynamicTerrain.get(i).getDy();
                    }
                    pr.x -= player.getDx();
                    pr.y -= player.getDy();
                    wasReseted.set(1, true);
                }
            }
        }
        for(int i = 0; i<dynamicTerrain.size();i++) {
            if(!wasReseted.get(i+1)) {
                InteractingRectangle dr = dynamicTerrain.get(i).getRectangle();
                for (StaticCreatures staticCreatures : staticTerrain) {
                    InteractingRectangle sr = staticCreatures.getRectangle();
                    if (dr.isIntersect(sr)) {
                        dr.x -= dynamicTerrain.get(i).getDx();
                        dr.y -= dynamicTerrain.get(i).getDy();
                        wasReseted.set(i + 1, true);
                    }
                }
            }
        }
        if(!wasReseted.get(0)) {
            for (StaticCreatures staticCreatures : staticTerrain) {
                InteractingRectangle sr = staticCreatures.getRectangle();
                if (pr.isIntersect(sr)) {
                    pr.x -= player.getDx();
                    pr.y -= player.getDy();
                    wasReseted.set(1, true);
                }
            }
        }
        for(DynamicCreatures dyn: dynamicTerrain) {
            InteractingRectangle dr = dyn.getRectangle();
            pushFromBorders(dr);
        }
    }

    private void fixStartingPositions(){
        pushDynamic();
        pushDynamicFromStatic();
        pushPlayerFromStatic();
    }

    private void pushDynamic(){
        InteractingRectangle pr = player.getRectangle();
        for(int i = 0; i<dynamicTerrain.size();i++) {
            InteractingRectangle dr = dynamicTerrain.get(i).getRectangle();
            for (int j = i + 1; j < dynamicTerrain.size(); j++) {
                InteractingRectangle sr = dynamicTerrain.get(j).getRectangle();
                if (dr.isIntersect(sr)) {
                    pushFrom(dr,sr);
                }
            }
        }
        for (DynamicCreatures dynamicCreatures : dynamicTerrain) {
            InteractingRectangle dr = dynamicCreatures.getRectangle();
            if (dr.isIntersect(pr)) {
                pushFrom(pr, dr);
            }
        }
    }

    private void pushDynamicFromStatic() {
        for(DynamicCreatures dyn: dynamicTerrain){
            InteractingRectangle dr = dyn.getRectangle();
            pushFromBorders(dr);

            for(StaticCreatures stat: staticTerrain){
                InteractingRectangle sr = stat.getRectangle();
                pushFrom(dr,sr);
            }
        }
    }

    private void pushFromBorders(InteractingRectangle rect) {
        if(rect.x<0) rect.x=0;
        if(rect.y<0) rect.y=0;
        if(rect.x+rect.wight>Constants.boardWight) rect.x = Constants.boardWight-rect.wight;
        if(rect.y+rect.height>Constants.boardHeight) rect.y = Constants.boardHeight-rect.height;
    }

    private void pushPlayerFromStatic() {
        InteractingRectangle pr = player.getRectangle();
        pushFromBorders(pr);
        for(StaticCreatures stat: staticTerrain){
            InteractingRectangle sr = stat.getRectangle();
            pushFrom(pr,sr);
        }
    }

    private void pushFrom(InteractingRectangle pr, InteractingRectangle sr) {
        if(pr.isIntersect(sr)){
            int directionToPush = 0;
            double intersect= Constants.boardWight;
            if((pr.x+pr.wight/2)<(sr.x+sr.wight/2)){
                if(intersect>(pr.x+pr.wight-sr.x)){
                    intersect = (pr.x+pr.wight-sr.x);
                    directionToPush=2;
                }
            }
            else{
                if(intersect>(sr.x+sr.wight-pr.x)){
                    intersect = (sr.x+sr.wight-pr.x);
                    directionToPush=4;
                }
            }
            if((pr.y+pr.height/2)<(sr.y+sr.height/2)){
                if(intersect>(pr.y+pr.height-sr.y)){
                    intersect = (pr.y+pr.height-sr.y);
                    directionToPush=1;
                }
            }
            else{
                if(intersect>(sr.y+sr.height-pr.y)){
                    intersect = (sr.y+sr.height-pr.y);
                    directionToPush=3;
                }
            }
            switch (directionToPush){
                case 1:
                    pr.y=sr.y-pr.height;
                    break;
                case 2:
                    pr.x=sr.x-pr.wight;
                    break;
                case 3:
                    pr.y=sr.y+sr.height;
                    break;
                case 4:
                    pr.x=sr.x+sr.wight;
                    break;
                default:
                    break;
            }
        }
    }

    public void calculatePath(int fx, int fy){
        player.setPath(null);
        player.setJ(0);
        int inf = 100000;
        int ix = player.getX()+(int)player.getWight()/2;
        int iy = player.getY()+(int)player.getHeight()/2;
        Node[][] nodes = new Node[Constants.boardWight][Constants.boardHeight];
        for(int i = 0; i < Constants.boardWight; i++){
            for(int j=0; j < Constants.boardHeight; j++){
                nodes[i][j]=new Node(i,j);
            }
        }
        for(StaticCreatures stat: staticTerrain){
            for(int i=(stat.getX()-(int)(player.getWight()/2));i<(stat.getX()+stat.getWight()+(int)(player.getWight()/2));i++){
                for(int j = (stat.getY()-(int)(player.getHeight()/2));j<(stat.getY()+stat.getHeight()+(int)(player.getHeight()/2));j++){
                    if(i>=0 && j>=0 && i<Constants.boardWight && j<Constants.boardHeight){
                        nodes[i][j].value = inf;
                    }
                }
            }
        }
        Node goal = nodes[fx][fy];
        Node start = nodes[ix][iy];
        start.g=0;
        start.f=h(start,goal);
        ArrayList<Node> openSet = new ArrayList<>();
        //ArrayList<Node> closedSet = new ArrayList<>();
        openSet.add(start);
        Node current;
        //System.out.println(start.i+" "+ start.j);
        //System.out.println(goal.i+" "+ goal.j);
        //System.out.println("");

        if(goal.value==inf) return;

        while(!openSet.isEmpty()){
            current = openSet.get(0);
            for(Node n: openSet){
                if((h(n,goal))<(h(current,goal))) current =n;
            }
            //System.out.println(current.i+" "+ current.j);
            if(current.i==goal.i && current.j==goal.j){
                ArrayList<Node> path = new ArrayList<>();
                path.add(current);
                while(current.cameFrom!=null) {
                    path.add(current.cameFrom);
                    current = current.cameFrom;
                }
                Collections.reverse(path);
                //System.out.println(path.toString());
                Node[] path1 = new Node[path.size()];
                for(int k = 0; k< path.size(); k++){
                    path1[k]=path.get(k);
                }
                player.setPath(path1);
                return;
            }
            ArrayList<Node> neighbours = new ArrayList<>();
            openSet.remove(current);
            //closedSet.add(current);
            if((current.i-1)>=0) {
                neighbours.add(nodes[current.i-1][current.j]);
                if((current.j-1)>=0) {
                    neighbours.add(nodes[current.i-1][current.j-1]);
                }
                if((current.j+1)<Constants.boardHeight) {
                    neighbours.add(nodes[current.i-1][current.j+1]);
                }
            }
            if((current.i+1)<Constants.boardWight) {
                neighbours.add(nodes[current.i + 1][current.j]);
                if((current.j-1)>=0) {
                    neighbours.add(nodes[current.i+1][current.j-1]);
                }
                if((current.j+1)<Constants.boardHeight) {
                    neighbours.add(nodes[current.i+1][current.j+1]);
                }
            }
            if((current.j-1)>=0) neighbours.add(nodes[current.i][current.j-1]);
            if((current.j+1)<Constants.boardHeight) neighbours.add(nodes[current.i][current.j+1]);
            for(Node n: neighbours){
                int tempG = current.g+n.value;
                if(tempG<n.g){
                    n.cameFrom=current;
                    n.g=tempG;
                    n.f=n.g+h(n,goal);
                    if(!doesIncludeNode(openSet,n)) openSet.add(n);
                }
            }
        }
        System.out.println("failure");
    }

    private int h(Node n, Node f){
        return (int)Math.sqrt((n.i-f.i)*(n.i-f.i)+(n.j-f.j)*(n.j-f.j));
    }

    private boolean doesIncludeNode(ArrayList<Node> arrayList,Node n){
        for(Node n1: arrayList){
            if (n1==n) return true;
        }
        return false;
    }
}
