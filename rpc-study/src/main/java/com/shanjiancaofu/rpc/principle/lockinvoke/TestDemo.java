package com.shanjiancaofu.rpc.principle.lockinvoke;

import org.junit.Test;

public class TestDemo {


    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        ILoginService proxyu = ProxyUtil.getProxyu(ILoginService.class);
        int count = proxyu.count(5);
        System.out.println(count);
    }
}

