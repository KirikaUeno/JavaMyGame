package com.actions;

import com.ui.GamePanel;
import com.ui.InventoryCell;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public class InventoryCellMouseListener extends MouseInputAdapter {
    private final InventoryCell inventoryCell;
    private final GamePanel panel;

    public InventoryCellMouseListener(InventoryCell inventoryCell, GamePanel panel){
        this.inventoryCell=inventoryCell;
        this.panel = panel;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        panel.mouseListener.mouseMoved(e);
    }

    @Override
    public void mousePressed(MouseEvent e){
        panel.mouseListener.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e){
        panel.mouseListener.mouseReleased(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        panel.mouseListener.mouseDragged(e);
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