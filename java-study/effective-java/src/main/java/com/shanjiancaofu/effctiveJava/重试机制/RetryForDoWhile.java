package com.shanjiancaofu.effctiveJava.重试机制;

public class RetryForDoWhile {



    public static void main(String[] args) {

        int maxRetryTime = 5;
        int time = 0;
        String result = null;
        do {
            time++;
            try {
                result = testRedo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (null == result && time < maxRetryTime);

    }

    private static String testRedo() {
        System.out.println("执行Redo代码");
        // 操作成功，返回结果，操作失败返回null
        return null;
    }



}


