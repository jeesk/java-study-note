package com.shanjiancaofu.effctiveJava;

import java.util.HashMap;
import java.util.Map;

// 使用泛型作为key， 而不是做为参数化类型
public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<Class<?>, Object>();

    public <T> void putFavorte(Class<T> type, T instance) {
        if (type == null) {
            throw new NullPointerException("Type is null");
        }
        favorites.put(type, instance);
    }

    public <T> T getFavoritet(Class<T> type) {
        return type.cast(favorites.get(type));
    }
}

class Demo {
    public static void main(String[] args) {
        Favorites favorites = new Favorites();
        Demo favoritet = favorites.getFavoritet(Demo.class);
    }
}
