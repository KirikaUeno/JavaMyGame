package com.actions;

import com.mapObjects.Stone;
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
        } else if(e.getButton()==1){
            Stone stone = new Stone(e.getX(),e.getY());
            stone.getRectangle().x=e.getX()-stone.getWight()/2;
            stone.getRectangle().y=e.getY()-stone.getHeight()/2;
            panel.getMap().staticTerrain.add(stone);
        } else if(e.getButton()==3){
            panel.getMap().calculatePath(e.getX(),e.getY());
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
