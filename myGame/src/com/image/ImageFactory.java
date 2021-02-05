package com.image;

import com.company.Constants;

import javax.swing.*;

public class ImageFactory {
    public static ImageIcon createImage(Images images){
        ImageIcon imageIcon;

        switch (images){
            case ICON:
                imageIcon=new ImageIcon(Constants.ICON_IMAGE_URL);
                break;
            case SKIN1:
                imageIcon=new ImageIcon(Constants.SKIN1_IMAGE_URL);
                break;
            case SKIN2:
                imageIcon=new ImageIcon(Constants.SKIN2_IMAGE_URL);
                break;
            case SKIN3:
                imageIcon=new ImageIcon(Constants.SKIN3_IMAGE_URL);
                break;
            case npsRight1:
                imageIcon=new ImageIcon(Constants.NPS_RIGHT1);
                break;
            case npsRight2:
                imageIcon=new ImageIcon(Constants.NPS_RIGHT2);
                break;
            case npsRight4:
                imageIcon=new ImageIcon(Constants.NPS_RIGHT4);
                break;
            case npsLeft1:
                imageIcon=new ImageIcon(Constants.NPS_LEFT1);
                break;
            case npsLeft2:
                imageIcon=new ImageIcon(Constants.NPS_LEFT2);
                break;
            case npsLeft4:
                imageIcon=new ImageIcon(Constants.NPS_LEFT4);
                break;
            case GRASS:
                imageIcon=new ImageIcon(Constants.GRASS_IMAGE_URL);
                break;
            case STONE:
                imageIcon=new ImageIcon(Constants.STONE_IMAGE_URL);
                break;
            default:
                return null;
        }

        return imageIcon;
    }
}
