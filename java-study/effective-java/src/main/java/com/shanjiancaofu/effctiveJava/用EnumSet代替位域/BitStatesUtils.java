package com.shanjiancaofu.effctiveJava.用EnumSet代替位域;

import org.junit.Test;

/**
 * 用户状态类，记录用户在平台使用系统中所有的状态。
 *
 * @author Administrator
 */
public class BitStatesUtils {
    public final static Long OP_BIND_PHONE = 1L << 0; // 用户绑定手机状态码	000000001 = 1
    public final static Long OP_BIND_EMAIL = 1L << 1; // 用户绑定邮箱状态码	000000010 = 2
    public final static Long OP_BASIC_INFO = 1L << 2; // 用户填写基本资料		4
    public final static Long OP_REAL_AUTH = 1L << 3; // 用户完成实名认证		8
    public final static Long OP_VEDIO_AUTH = 1L << 4; // 用户完成视频认证		16  =  1 * 2 * 2 * 2 * 2
    public final static Long HAS_BIDREQUEST_IN_PROCESS = 1L << 5;// 用户有一个借款在申请流程当中	32
    public final static Long HAS_TRUSTEESHIP_SETPAYPASS = 1L << 6;// 是否完成托管交易密码设置
    public final static Long HAS_TRUSTEESHIP_VERIFY = 1L << 7;// 是否完成托管认证设置

    /**
     * @param states 所有状态值
     * @param value  需要判断状态值
     * @return 是否存在
     */
    public static boolean hasState(long states, long value) {
        return (states & value) != 0;
    }

    /**
     * @param states 已有状态值
     * @param value  需要添加状态值
     * @return 新的状态值
     */
    public static long addState(long states, long value) {
        if (hasState(states, value)) {
            return states;
        }
        return (states | value);
    }

    /**
     * @param states 已有状态值
     * @param value  需要删除状态值
     * @return 新的状态值
     */
    public static long removeState(long states, long value) {
        if (!hasState(states, value)) {
            return states;
        }
        return states ^ value;
    }


    @Test
    public void test() {
        // 1 +4
        System.out.println(OP_BIND_PHONE|OP_BASIC_INFO);
    }
}
