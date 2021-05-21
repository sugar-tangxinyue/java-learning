package com.learn.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * 读取配置文件中的值
 */
public class PropertyMgr {

    private PropertyMgr propertyMgr = new PropertyMgr();

    private PropertyMgr() {
    }

    public PropertyMgr getInstanse() {
        return propertyMgr;
    }

    static Properties props = new Properties();

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config/config.properties"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println(e);
        }
    }

    /**
     * 获取value值
     *
     * @param key
     * @return
     */
    public static Object get(String key) {
        if (null == props) {
            return null;
        }
        if (!props.containsKey(key)) {
            return null;
        }
        return props.get(key);
    }

    /**
     * 获取string
     *
     * @param key
     * @return
     */
    public static String getString(String key) {
        Object value = get(key);
        if (null == value) {
            return null;
        }
        return (String) value;
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt(PropertyMgr.getString("tankSpeed")));
    }
}
