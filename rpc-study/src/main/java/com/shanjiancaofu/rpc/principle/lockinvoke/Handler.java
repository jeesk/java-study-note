package com.shanjiancaofu.rpc.principle.lockinvoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * Handler.java
 *
 * @author jeesk
 * @version 2018年5月12日 下午10:31:21
 * @since 1.0
 */
public class Handler<T> implements InvocationHandler {
    private T t = null;

    @SuppressWarnings("unchecked")
    public T createProductDAO(T t) {

        this.t = t;
        return (T) Proxy.newProxyInstance(t.getClass().getClassLoader(),
                t.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object o = null;
        o = method.invoke(t, args);
        return o;
    }

}
