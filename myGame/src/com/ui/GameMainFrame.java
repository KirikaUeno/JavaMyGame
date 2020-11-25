package com.ui;

import com.company.Constants;
import com.image.*;

import javax.swing.*;

public class GameMainFrame extends JFrame {
    public GameMainFrame(){
        initializeLayout();
    }

    private void initializeLayout(){
        setTitle(Constants.title);
        setIconImage(ImageFactory.createImage(Image.ICON).getImage());

        add(new GamePanel());

        pack();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
