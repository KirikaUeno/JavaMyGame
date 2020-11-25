package com.image;

import com.company.Constants;

import javax.swing.*;

public class ImageFactory {
    public static ImageIcon createImage(Image image){
        ImageIcon imageIcon;

        switch (image){
            case ICON:
                imageIcon=new ImageIcon(Constants.ICON_IMAGE_URL);
                break;
            case BACKGROUND:
                imageIcon=new ImageIcon(Constants.BACKGROUND_IMAGE_URL);
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
            case SKIN4:
                imageIcon=new ImageIcon(Constants.SKIN4_IMAGE_URL);
                break;
            case SKIN5:
                imageIcon=new ImageIcon(Constants.SKIN5_IMAGE_URL);
                break;
            case SKIN6:
                imageIcon=new ImageIcon(Constants.SKIN6_IMAGE_URL);
                break;
            default:
                return null;
        }

        return imageIcon;
    }
}
