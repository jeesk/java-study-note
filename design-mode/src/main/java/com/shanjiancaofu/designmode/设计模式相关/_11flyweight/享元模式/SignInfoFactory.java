package com.shanjiancaofu.designmode.设计模式相关._11flyweight.享元模式;

import java.util.HashMap;

public class SignInfoFactory {
    //池容器
    private static HashMap<String, SignInfo> pool = new HashMap<String, SignInfo>();

    //报名信息的对象工厂
   /* @Deprecated
    public static SignInfo() {
        return new SignInfo();
    }*/

    //从池中获得对象
    public static SignInfo getSignInfo(String key) {
        //设置返回对象
        SignInfo result = null;
        //池中没有该对象，则建立，并放入池中
        if (!pool.containsKey(key)) {
           // System.out.println(key + "---- 建立对象，并放置到池中 ");
            result = new SignInfo4Pool(key);
            pool.put(key, result);
        } else {
            result = pool.get(key);
           // System.out.println(key + "--- 直接从池中取得 ");
        }
        return result;
    }
}

class Client1 {
    public static void main(String[] args) {

        //  享元模式有并发性的问题,
        //初始化对象池
        for (int i = 0; i < 4; i++) {
            String subject = " 科目 " + i;
            //初始化地址
            for (int j = 0; j < 30; j++) {
                String key = subject + " 考试地点 " + j;
                SignInfoFactory.getSignInfo(key);
            }
        }


        SignInfo signInfo = SignInfoFactory.getSignInfo(" 科目 1 考试地点 1");

        //  在多线程并发的情况下面, 享元模式有大量的并发性问题. 所以要分成内部状态和外部状态
    }
}
