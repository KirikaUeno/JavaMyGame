package com.actions;

import com.ui.GamePanel;
import com.ui.NearMouseBox;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public class MainMouseListener extends MouseInputAdapter {
    private final GamePanel panel;
    private final NearMouseBox box;
    public MainMouseListener(GamePanel gamePanel){
        panel=gamePanel;
        box=panel.getBox();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        box.setPosX(e.getX()-box.getWidth()+((box.getHighlightedCellPanel() == null) ? 0 : box.getHighlightedCellPanel().getPosX()));
        box.setPosY(e.getY()-box.getHeight()+((box.getHighlightedCellPanel() == null) ? 0 : box.getHighlightedCellPanel().getPosY()));
        panel.mouseMovedGamePanel();
        //System.out.println(((box.getHighlightedPanel() == null) ? 0 : box.getHighlightedPanel().getPosX()));
    }

    @Override
    public void mousePressed(MouseEvent e){
        if(box.getHighlightedCellPanel()!= null && box.getHighlightedCellPanel().getItem()!=null) {
            box.setPressedCellPanel(box.getHighlightedCellPanel());
            box.setStartShifts(e.getX(), e.getY());
            box.setDraggedItem(box.getPressedCellPanel().getItem());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e){
        panel.setImageProperties(false,0,0);
        if(box.getHighlightedCellPanel()!=null && box.getDraggedItem()!=null){
            box.getHighlightedCellPanel().putItem(box.getDraggedItem());
        } else if(box.getDraggedItem()!=null){
            box.getPressedCellPanel().putItem(box.getDraggedItem());
        }
        if(box.getHighlightedCellPanel()!= null && box.getHighlightedCellPanel().getItem()!=null){
            box.setPosX(e.getX()-box.getWidth()+box.getPressedCellPanel().getPosX());
            box.setPosY(e.getY()-box.getHeight()+box.getPressedCellPanel().getPosY());
            panel.mouseMovedGamePanel();
            box.setVisible(true);
        }
        box.setPressedCellPanel(null);
        box.removeDraggedItem();
    }

    @Override
    public void mouseDragged(MouseEvent e){
        if(box.getPressedCellPanel()!=null){
            box.setVisible(false);
            panel.setImageProperties(true,e.getX()+box.getPressedCellPanel().getPosX()-box.getStartXShift(),e.getY()+box.getPressedCellPanel().getPosY()-box.getStartYShift());
        }
    }
}
