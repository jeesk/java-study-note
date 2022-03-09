package com.shanjiancaofu.rpc.principle.lockinvoke;

public class ProxyUtil {

    public static <T> T getProxyu(Class<T> t) throws IllegalAccessException, InstantiationException {
        return t.newInstance();
    }
}
