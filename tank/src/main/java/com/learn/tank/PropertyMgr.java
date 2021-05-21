package com.learn.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * 读取配置文件中的值
 */
public class PropertyMgr {
    static Properties props=null;
    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if(null==props){
            return null;
        }
        if(!props.containsKey(key)){
            return null;
        }
        return props.get(key);
    }
}
