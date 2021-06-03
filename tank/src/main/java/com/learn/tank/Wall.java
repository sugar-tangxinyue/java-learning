package com.learn.tank;

import java.awt.*;

public class Wall extends GameObject {

    private Rectangle rectangle = new Rectangle();
    private int x;
    private int y;
    private int width;
    private int height;

    public Wall(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.rectangle.x = x;
        this.rectangle.y = y;
        this.rectangle.width = width;
        this.rectangle.height = height;
        this.width = width;
        this.height = height;
        GameModel.gameObjectList.add(this);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(this.x, this.y, this.width, this.height);
        g.setColor(c);
    }


    public Rectangle getRectangle() {
        return this.rectangle;
    }
}
