package com.ui;

import javax.swing.*;
import java.awt.*;

public class NearMouseBox extends PositioningJPanel {
    private final JLabel label = new JLabel();
    public NearMouseBox(){
        setPreferredSize(new Dimension(100,40));
        setBackground(Color.CYAN);
        add(label);
    }
    public void setText(String text){
        label.setText(text);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Toolkit.getDefaultToolkit().sync();
    }
}
