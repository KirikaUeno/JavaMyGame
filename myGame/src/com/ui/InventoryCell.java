package com.ui;

import com.actions.InventoryCellMouseListener;
import com.items.Items;

import javax.swing.*;
import java.awt.*;

public class InventoryCell extends PositioningJPanel {
    private Items item;
    private final GamePanel panel;
    private boolean isHighlighted = false;
    private final ImageIcon highlightingImage = new ImageIcon("images/items/highlightingCell.png");

    public InventoryCell(GamePanel panel,int x, int y, int w, int h){
        wight=w;
        height=h;
        setPreferredSize(new Dimension(wight,height));
        setFocusable(true);
        this.panel=panel;
        setBackground(Color.GRAY);
        InventoryCellMouseListener mouseListener = new InventoryCellMouseListener(this, panel);
        addMouseMotionListener(panel.mouseListener);
        addMouseListener(mouseListener);
        //addMouseListener(panel.mouseListener);
        posX=x;
        posY=y;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(item!=null) {
            g.drawImage(item.getIcon().getImage(),0,0,this);
        }
        if(isHighlighted) g.drawImage(highlightingImage.getImage(),0,0,this);
        Toolkit.getDefaultToolkit().sync();
    }

    public void putItem(Items item){
        this.item = item;
    }
    public void removeItem(){
        this.item = null;
    }

    public void showDescription(){
        panel.getBox().setHighlightedCellPanel(this);
        isHighlighted=true;
        if(item!=null) {
            panel.getBox().setText(item.getDescription());
            panel.getBox().setVisible(true);
        }
    }
    public void closeDescription(){
        isHighlighted = false;
        panel.getBox().setVisible(false);
        panel.getBox().setHighlightedCellPanel(null);
    }

    public Items getItem(){
        return item;
    }
}
