package com.ui;

import com.items.Items;

import javax.swing.*;
import java.awt.*;

public class NearMouseBox extends PositioningJPanel {
    private final JLabel label = new JLabel();
    private InventoryCell highlightedCellPanel = null;
    private InventoryCell pressedCellPanel = null;
    private Items draggedItem = null;
    private int startXShift = 0;
    private int startYShift = 0;

    public NearMouseBox(){
        setPreferredSize(new Dimension(100,40));
        setBackground(Color.CYAN);
        SpringLayout layout = new SpringLayout();
        setLayout(layout);
        add(label);
    }
    public void setText(String text){
        label.setText(text);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setPreferredSize(new Dimension(g.getFontMetrics().stringWidth(label.getText()),g.getFontMetrics().getHeight()));
        Toolkit.getDefaultToolkit().sync();
    }

    public void setHighlightedCellPanel(InventoryCell panel){
        highlightedCellPanel =panel;
    }
    public InventoryCell getHighlightedCellPanel(){
        return highlightedCellPanel;
    }

    public void setPressedCellPanel(InventoryCell panel){
        pressedCellPanel =panel;
    }
    public InventoryCell getPressedCellPanel(){
        return pressedCellPanel;
    }

    public void setStartShifts(int x, int y){
        startXShift=x;
        startYShift=y;
    }
    public int getStartXShift(){
        return startXShift;
    }
    public int getStartYShift(){
        return startYShift;
    }

    public Items getDraggedItem(){
        return draggedItem;
    }
    public void setDraggedItem(Items item){
        draggedItem = item;
        pressedCellPanel.removeItem();
    }
    public void removeDraggedItem(){
        draggedItem=null;
    }
}
