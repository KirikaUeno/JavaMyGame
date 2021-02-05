package com.ui;

import com.company.Constants;
import com.items.GreatSword;

import javax.swing.*;
import java.awt.*;

public class Inventory extends PositioningJPanel {
    private final int quantityOfCells = 49;
    private final InventoryCell[] inventoryCells = new InventoryCell[quantityOfCells];
    private final GamePanel panel;

    public Inventory(GamePanel panel){
        setPreferredSize(new Dimension(Constants.boardWight/3,Constants.boardHeight*3/4));
        setFocusable(true);
        this.panel= panel;
        posX=Constants.boardWight-10-this.getWidth();
        posY=Constants.boardHeight/2-this.getHeight();

        initializeVariables();
    }
    private void initializeVariables(){
        this.setBackground(Color.BLACK);

        SpringLayout layout = new SpringLayout();
        inventoryCells[0] = new InventoryCell(panel,posX+10,posY+100);
        layout.putConstraint(SpringLayout.WEST, inventoryCells[0], 10, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, inventoryCells[0], 100, SpringLayout.NORTH, this);
        add(inventoryCells[0]);
        int numberInString = Constants.boardWight/(3*quantityOfCells);
        for(int i = 1; i<quantityOfCells; i++){
            if(i%numberInString==0){
                inventoryCells[i] = new InventoryCell(panel,posX+10,inventoryCells[i-1].getPosY()+10+inventoryCells[i-1].getHeight());
                layout.putConstraint(SpringLayout.WEST, inventoryCells[i], 10, SpringLayout.WEST, this);
                layout.putConstraint(SpringLayout.NORTH, inventoryCells[i], 10, SpringLayout.SOUTH, inventoryCells[i-1]);
            } else {
                inventoryCells[i] = new InventoryCell(panel,inventoryCells[i - 1].getPosX()+10+inventoryCells[i - 1].getWidth(),inventoryCells[i - 1].getPosY());
                layout.putConstraint(SpringLayout.WEST, inventoryCells[i], 10, SpringLayout.EAST, inventoryCells[i - 1]);
                layout.putConstraint(SpringLayout.NORTH, inventoryCells[i], 0, SpringLayout.NORTH, inventoryCells[i - 1]);
            }
            add(inventoryCells[i]);
        }
        setLayout(layout);

        inventoryCells[0].putItem(new GreatSword());
    }
}
