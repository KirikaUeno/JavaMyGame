package com.company;

import com.objects.Personas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsEventListener implements ActionListener{
    private Personas character;

    public ButtonsEventListener(Personas character){
        this.character=character;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        switch (str){
            case "skin 1":
                this.character.button1();
                break;
            case "skin 2":
                this.character.button2();
                break;
            case "skin 3":
                this.character.button3();
                break;
            case "skin 4":
                this.character.button4();
                break;
            case "skin 5":
                this.character.button5();
                break;
            case "skin 6":
                this.character.button6();
                break;
            default:
                break;
        }
    }
}