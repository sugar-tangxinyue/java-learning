package com.learn.tank;

import java.awt.*;

public class Explode {

    private int x;
    private int y;
    public TankFrame tankFrame;
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
    private int step;


    public Explode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
//        new Audio("audio/explode.wav").play();
    }

    public void paint(Graphics g) {
        if(step>ResourceMgr.explodes.length){
            tankFrame.explodeList.remove(this);
            return;
        }
        g.drawImage(ResourceMgr.explodes[step], x, y, null);
        step++;
    }

}
