package com.actions;

import com.mapObjects.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MoveAction extends AbstractAction {
    private final int direction;
    private final boolean pressed;
    private final Player player;
    private final int shift;

    public MoveAction(int direction, boolean pressed, Player player,int shift){
        this.direction = direction;
        this.player = player;
        this.pressed = pressed;
        this.shift = shift;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.setPressedButtons(direction,pressed,shift);
    }
}
