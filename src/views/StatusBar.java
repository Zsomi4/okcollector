/*
 * File: StatusBar.java
 * Created Date: 2021-09-24 13:51:43
 * Author: Sallai Andras
 * Github: https://github.com/andteki
 * -----
 * Last Modified: 2021-09-24
 * Modified By: Sallai Andras
 * -----
 * Copyright (c) 2021 Sallai Andras
 * 
 * GNU GPL v2
 */

package views;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class StatusBar extends JPanel {
    /*
     * A Java Swing és AWT csomag nem tartalmaz Status sávot. 
     * Minden programozói könyvtár, amely felhasználói felület
     * létrehozására képes, általában tartalmaz stuszsáv
     * megvalósítására alkalmas osztályt, vagy valamilyen
     * eszközt. A Java elég elterjedt, ennek ellenére nem
     * tette bele statuszsáv megvalósítására alkalmas 
     * osztály. 
     */
    JLabel statusLabel;

    public StatusBar(int width) {        
        setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        setSize(width, 25);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        statusLabel = new JLabel("Kész");
        setMessage("Kész");
        add(statusLabel);
    }
    
    public void setSize(int x, int y) {
        setMaximumSize(new Dimension(x, y));
        setMinimumSize(new Dimension(x, y));
        setPreferredSize(new Dimension(x, y));
    }

    public void setMessage(String message) {
        statusLabel.setText(message);
    }
}
