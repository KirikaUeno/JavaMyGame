package com.ui;

import com.company.Constants;
import com.company.KeyEventListener;
import com.company.ButtonsEventListener;
import com.image.*;
import com.image.Image;
import com.objects.Personas;
import com.objects.Skin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    private ImageIcon backgroundImage;
    private Timer timer;
    private Personas character;
    private boolean inGame=true;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;


    public GamePanel(){
        setPreferredSize(new Dimension(Constants.boardWight,Constants.boardHeight));
        addKeyListener(new KeyEventListener(this));
        setFocusable(true);

        initializeVariables();
    }
    private void initializeVariables(){
        this.character = new Personas();
        this.backgroundImage = ImageFactory.createImage(Image.BACKGROUND);
        this.timer=new Timer(Constants.gameSpeed,new GameLoop(this));
        this.timer.start();

        this.button1 = new Button("skin 1");
        add(button1);
        this.button2 = new Button("skin 2");
        add(button2);
        this.button3 = new Button("skin 3");
        add(button3);
        this.button4 = new Button("skin 4");
        add(button4);
        this.button5 = new Button("skin 5");
        add(button5);
        this.button6 = new Button("skin 6");
        add(button6);
        button1.addActionListener(new ButtonsEventListener(this.character));
        button2.addActionListener(new ButtonsEventListener(this.character));
        button3.addActionListener(new ButtonsEventListener(this.character));
        button4.addActionListener(new ButtonsEventListener(this.character));
        button5.addActionListener(new ButtonsEventListener(this.character));
        button6.addActionListener(new ButtonsEventListener(this.character));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage.getImage(),0,0,null);

        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        addKeyListener(new KeyEventListener(this));
        if(inGame) {
            Skin skin = character.getSkin();
            g.drawImage(skin.getImageHead(),character.getX(),character.getY(),this);
            g.drawImage(skin.getImageBody(),character.getX(),character.getY()+69,this);
            grabFocus();
        } else {
            if (timer.isRunning()) {
                timer.stop();
            }
        }

    }


    public void doOneLoop() {
        update();
        repaint();

    }

    private void update(){
        this.character.move();
    }

    public void keyReleased(KeyEvent e) {
        this.character.keyReleased(e);
    }

    public void keyPressed(KeyEvent e) {
        this.character.keyPressed(e);
    }
}
