package com.actions;

import com.ui.GamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class UIKeyAction extends AbstractAction {
    private final char key;
    private GamePanel panel;

    public UIKeyAction(char key, GamePanel panel){
        this.key = key;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(key){
            case 'I':
                panel.openInventory();
                break;
            default:
                break;
        }
    }
}
