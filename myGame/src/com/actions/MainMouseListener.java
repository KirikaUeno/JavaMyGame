package com.actions;

import com.ui.GamePanel;

import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public class MainMouseListener extends MouseInputAdapter {
    private final GamePanel panel;
    private final
    public MainMouseListener(GamePanel gamePanel){
        panel=gamePanel;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        panel.getBox().setPosX(e.getX()-panel.getBox().getWidth());
        panel.getBox().setPosY(e.getY()-panel.getBox().getHeight());
        panel.mouseMovedGamePanel();
        //System.out.println(e.getComponent());
    }
}
