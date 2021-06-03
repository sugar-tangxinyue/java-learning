package com.learn.tank;

import com.learn.tank.core.ColliderChain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    public static List<GameObject> gameObjectList = null;
    ColliderChain colliderChain = new ColliderChain();
    public static Tank myTank =null;

    private static GameModel INSTANCE = new GameModel();

    static {
        init();
    }

    private static void init() {
        gameObjectList = new ArrayList<>();
        myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD);
        int initTankCoune = Integer.parseInt(PropertyMgr.getString("initTankCount"));
        for (int i = 0; i < initTankCoune; i++) {
            new Tank(50 + i * 80, 50, Dir.DOWN, Group.BAD);
        }
        new Wall(0, 30, TankFrame.GAME_WIDTH, 2);
        new Wall(0, TankFrame.GAME_HEIGHT - 2, TankFrame.GAME_WIDTH, 2);
        new Wall(400, 0, 20, TankFrame.HEIGHT);
        new Wall(500, 0, 20, TankFrame.HEIGHT);
    }

    private GameModel() {
    }

    public static GameModel getInstance() {
        return INSTANCE;
    }

    //坦克坐标变成变量，可以动起来
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("objects:" + gameObjectList.size(), 10, 50);
        g.setColor(c);
        //画坦克
        myTank.paint(g);
        //画出其他类型
        for (int i = 0; i < gameObjectList.size(); i++) {
            gameObjectList.get(i).paint(g);
        }
        //碰撞
        for (int i = 0; i < gameObjectList.size(); i++) {
            for (int j = i + 1; j < gameObjectList.size(); j++) {
                colliderChain.collider(gameObjectList.get(i), gameObjectList.get(j));
            }
        }
    }
}
