package com.learn.tank.abstracttank;

import com.learn.tank.Dir;
import com.learn.tank.Group;
import com.learn.tank.fire.Fire;

import java.awt.*;

public abstract class BaseTank {
    public abstract void paint(Graphics g);

    public abstract Group getGroup();

    public abstract Rectangle getRectangle();

    public abstract void die();

    public abstract void setMoving(boolean b);

    public abstract void setDir(Dir left);

    public abstract void fire(Fire instance);

    public abstract int getX();

    public abstract int getY();
}
