package com.ui;

import com.company.Constants;
import com.image.*;

import javax.swing.*;
import java.util.Objects;

public class MainFrame extends JFrame {
    public MainFrame(){
        initializeLayout();
    }

    private void initializeLayout(){
        setTitle(Constants.title);
        setIconImage(Objects.requireNonNull(ImageFactory.createImage(Images.ICON)).getImage());

        add(new GamePanel(this));

        pack();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
}
