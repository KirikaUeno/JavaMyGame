package com.items;

import com.company.Constants;

import javax.swing.*;

public class GreatSword extends Items{
    public GreatSword(){
        icon = new ImageIcon(Constants.GREAT_SWORD_URL);
        description = "GREAT SWORD, atk = 10";
    }
}
