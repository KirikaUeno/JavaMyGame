package com.ui;

import com.actions.MainMouseListener;
import com.actions.UIKeyAction;
import com.company.Constants;
import com.actions.MoveAction;
import com.image.*;
import com.image.Images;
import com.items.GreatSword;
import com.items.Items;
import com.maps.Maps;
import com.mapObjects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Arrays;

public class GamePanel extends PositioningJPanel {
    private final JLabel buttons = new JLabel("0 0 0 0");
    private Maps map;
    private Player player;
    private Inventory inv;
    private boolean isInvOpen = false;
    private final NearMouseBox box = new NearMouseBox();
    private final SpringLayout layout = new SpringLayout();
    public MainMouseListener mouseListener = new MainMouseListener(this);
    private int imagePosX=0;
    private int imagePosY=0;
    private boolean drawImage = false;

    public GamePanel(MainFrame frame){
        setPreferredSize(new Dimension(Constants.boardWight,Constants.boardHeight));
        setFocusable(true);

        initializeVariables();
    }
    private void initializeVariables(){
        this.player=new Player();
        bindKeys();
        add(box);
        add(buttons);
        createMap();
        inv = new Inventory(this);
        add(inv);
        inv.setVisible(false);
        box.setVisible(false);
        addMouseMotionListener(mouseListener);
        addMouseListener(mouseListener);

        layout.putConstraint(SpringLayout.EAST, inv, -10, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, inv, 0, SpringLayout.VERTICAL_CENTER, this);
        setLayout(layout);

        Timer timer = new Timer(Constants.gameSpeed, e -> doOneLoop());
        timer.start();
        posX=0;
        posY=0;
    }

    public void mouseMovedGamePanel() {
        layout.putConstraint(SpringLayout.WEST, box, box.getPosX(), SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, box, box.getPosY(), SpringLayout.NORTH, this);
        setLayout(layout);
        revalidate();
        repaint();
    }

    private void createMap() {
        Stone stone = new Stone(350,150);
        ArrayList<StaticCreatures> statTerrain= new ArrayList<>();
        statTerrain.add(stone);
        NPS girl = new NPS(ImageFactory.createImage(Images.SKIN2),ImageFactory.createImage(Images.SKIN3),150,150,Constants.girlWight,Constants.girlHeight);
        ArrayList<DynamicCreatures> dynTerrain= new ArrayList<>();
        dynTerrain.add(girl);
        map = new Maps(player,statTerrain,dynTerrain,ImageFactory.createImage(Images.GRASS));
    }

    private void bindKeys(){
        getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "pressedLeft");
        getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "pressedRight");
        getInputMap().put(KeyStroke.getKeyStroke("UP"), "pressedUp");
        getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "pressedDown");
        getInputMap().put(KeyStroke.getKeyStroke("released LEFT"), "releasedLeft");
        getInputMap().put(KeyStroke.getKeyStroke("released RIGHT"), "releasedRight");
        getInputMap().put(KeyStroke.getKeyStroke("released UP"), "releasedUp");
        getInputMap().put(KeyStroke.getKeyStroke("released DOWN"), "releasedDown");
        getActionMap().put("pressedLeft",new MoveAction(1,true,player,0));
        getActionMap().put("pressedRight",new MoveAction(3,true,player,0));
        getActionMap().put("pressedUp",new MoveAction(0,true,player,0));
        getActionMap().put("pressedDown",new MoveAction(2,true,player,0));
        getActionMap().put("releasedLeft",new MoveAction(1,false,player,0));
        getActionMap().put("releasedRight",new MoveAction(3,false,player,0));
        getActionMap().put("releasedUp",new MoveAction(0,false,player,0));
        getActionMap().put("releasedDown",new MoveAction(2,false,player,0));

        getInputMap().put(KeyStroke.getKeyStroke("shift LEFT"), "pressedLeftShift");
        getInputMap().put(KeyStroke.getKeyStroke("shift RIGHT"), "pressedRightShift");
        getInputMap().put(KeyStroke.getKeyStroke("shift UP"), "pressedUpShift");
        getInputMap().put(KeyStroke.getKeyStroke("shift DOWN"), "pressedDownShift");
        getInputMap().put(KeyStroke.getKeyStroke("shift released LEFT"), "releasedLeftShift");
        getInputMap().put(KeyStroke.getKeyStroke("shift released RIGHT"), "releasedRightShift");
        getInputMap().put(KeyStroke.getKeyStroke("shift released UP"), "releasedUpShift");
        getInputMap().put(KeyStroke.getKeyStroke("shift released DOWN"), "releasedDownShift");
        getActionMap().put("pressedLeftShift",new MoveAction(1,true,player,1));
        getActionMap().put("pressedRightShift",new MoveAction(3,true,player,1));
        getActionMap().put("pressedUpShift",new MoveAction(0,true,player,1));
        getActionMap().put("pressedDownShift",new MoveAction(2,true,player,1));
        getActionMap().put("releasedLeftShift",new MoveAction(1,false,player,1));
        getActionMap().put("releasedRightShift",new MoveAction(3,false,player,1));
        getActionMap().put("releasedUpShift",new MoveAction(0,false,player,1));
        getActionMap().put("releasedDownShift",new MoveAction(2,false,player,1));

        getInputMap().put(KeyStroke.getKeyStroke("I"), "inventory");
        getActionMap().put("inventory",new UIKeyAction('I',this));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(drawImage) g.drawImage(box.getDraggedItem().getIcon().getImage(), imagePosX,imagePosY,this);
        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        drawMap(g);
    }

    private void drawMap(Graphics g) {
        g.drawImage(map.background.getImage(),0,0,null);
        for(StaticCreatures stat: map.staticTerrain){
            g.drawImage(stat.getSprite().getImage(),stat.getX(),stat.getY(),this);
        }

        for(DynamicCreatures dyn: map.dynamicTerrain){
            g.drawImage(dyn.getSprite().getImage(),dyn.getX(),dyn.getY(),this);
        }

        Skin skin = map.player.getSkin();
        g.drawImage(skin.getImageHead().getImage(),player.getX(),player.getY(),this);
    }

    public void doOneLoop() {
        update();
        repaint();
    }

    private void update(){
        map.update();
        updateGUI();
    }

    private void updateGUI() {
        buttons.setText(""+ Arrays.toString(player.getPressedButtons()));
    }

    public void openInventory(){
        if(!isInvOpen){
            inv.setVisible(true);
            isInvOpen=true;
        } else{
            inv.setVisible(false);
            isInvOpen=false;
        }
    }

    public NearMouseBox getBox(){
        return box;
    }

    public void setImageProperties(boolean drawImage, int posX,int posY){
        this.drawImage = drawImage;
        imagePosX = posX;
        imagePosY = posY;
    }

    public Maps getMap() {
        return map;
    }
}
