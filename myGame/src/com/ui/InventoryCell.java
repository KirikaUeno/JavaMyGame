package com.ui;

import com.actions.InventoryCellMouseListener;
import com.items.Items;

import javax.swing.*;
import java.awt.*;

public class InventoryCell extends PositioningJPanel {
    private Items item;
    private final GamePanel panel;

    public InventoryCell(GamePanel panel,int x, int y){
        setPreferredSize(new Dimension(40,40));
        setFocusable(true);
        this.panel=panel;
        setBackground(Color.GRAY);
        InventoryCellMouseListener mouseListener = new InventoryCellMouseListener(this);
        addMouseMotionListener(panel.mouseListener);
        addMouseListener(mouseListener);
        posX=x;
        posY=y;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(item!=null) {
            g.drawImage(item.getIcon().getImage(),0,0,this);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    public void putItem(Items item){
        this.item = item;
    }
    public void removeItem(){
        this.item = null;
    }

    public void showDescription(){
        if(item!=null) {
            panel.getBox().setText(item.getDescription());
            panel.getBox().setVisible(true);
        }
    }
    public void closeDescription(){
        panel.getBox().setVisible(false);
    }
}
