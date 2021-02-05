package com.actions;

import com.ui.InventoryCell;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public class InventoryCellMouseListener extends MouseInputAdapter {
    private InventoryCell inventoryCell;

    public InventoryCellMouseListener(InventoryCell inventoryCell){
        this.inventoryCell=inventoryCell;
    }

    @Override
    public void mouseEntered(MouseEvent e){
        inventoryCell.showDescription();
    }
    @Override
    public void mouseExited(MouseEvent e){
        inventoryCell.closeDescription();
    }
}