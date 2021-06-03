package com.learn.tank;

import java.awt.*;

public class Explode extends GameObject {

    private int x;
    private int y;
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
    private int step;


    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
        GameModel.gameObjectList.add(this);
//        new Audio("audio/explode.wav").play();
    }

    public void paint(Graphics g) {
        if (step >= ResourceMgr.explodes.length) {
            GameModel.gameObjectList.remove(this);
            return;
        }
        g.drawImage(ResourceMgr.explodes[step], x, y, null);
        step++;
    }

}
