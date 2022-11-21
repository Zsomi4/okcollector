/*
 * File: CollectorController.java
 * Created Date: 2021-09-24 10:42:41
 * Author: Sallai Andras
 * Github: https://github.com/andteki
 * -----
 * Last Modified: 2022-11-21
 * Modified By: Gubis Zsombor Dániel
 * -----
 * Copyright (c) 2021 Sallai Andras
 * 
 * GNU GPL v2
 */

package controllers;

import java.util.ArrayList;

import models.Page;
import views.MainWindow;

/* 
    FIXME Az öröklés felesleges. 
    Ha megszüntetjük szükség lesz egy mainWindow adattagra. 
*/

public class CollectorController extends MainController {

    String utvonal = mainWindow.urlField.getText();
    Page page = new Page();

    public CollectorController(MainWindow mainWindow) {
        super(mainWindow);
    }

    public void pasteButtonEvent() {
            mainWindow.pasteButton.addActionListener(event -> {
            pasteButtonMessage();
            mainWindow.urlField.paste();
        });
    }

    public void pasteButtonMessage() {
        System.out.println("beillesztés");
    }

    public void startButtonEvent() {
        mainWindow.startButton.addActionListener(event -> {

            if (utvonal.isEmpty()) {
                utvonal = "https://index.hu";
            }
            
            page.setUrl(utvonal);
            ArrayList<String> w = page.getContent();

            for(String word : w) {
                if (mainWindow.wordsModel.indexOf(word)<0) {
                    mainWindow.wordsModel.addElement(word);
                }                
            }
            Integer wordCount = mainWindow.wordsModel.getSize();
            mainWindow.statusBar.setMessage("Szavak: " + wordCount.toString());
        
        });   
    }   
}
