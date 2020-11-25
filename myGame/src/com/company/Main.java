package com.company;
import com.objects.Skin;
import com.image.Image;
import com.ui.GameMainFrame;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        /*EventQueue.invokeLater(() -> {
            new GameMainFrame();
        });*/

        SwingUtilities.invokeLater(()-> {
            new GameMainFrame();
        });

    }
}