package com.company;

import com.ui.GamePanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyEventListener extends KeyAdapter {
    private GamePanel board;

    public KeyEventListener(GamePanel board){
        this.board=board;
    }


    public void keyReleased(KeyEvent e) {
        this.board.keyReleased(e);
    }

    public void keyPressed(KeyEvent e) {
        this.board.keyPressed(e);
    }
}
