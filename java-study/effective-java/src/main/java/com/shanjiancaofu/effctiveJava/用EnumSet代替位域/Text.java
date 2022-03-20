package com.shanjiancaofu.effctiveJava.用EnumSet代替位域;

import org.junit.Test;

import java.util.EnumSet;
import java.util.Set;

public class Text {
    private static final int STYLE1 = 1 << 0;
    private static final int STYLE2 = 1 << 1;
    private static final int STYLE4 = 1 << 2;
    private static final int STYLE8 = 1 << 3;

    // 如果枚举类型常用于集合中话， 那么使用EnumSet代替位域更好。

    public enum Style {
        DOLB, ITALIC, UNDERLIC;
    }
    public void apply(Set<Style> styles) {

        EnumSet<Style> dolb = EnumSet.of(Style.DOLB, Style.ITALIC);

    }

    @Test
    public void test() {
        // 增加， 有1 ，则为1， 表示相加
        System.out.println(STYLE2 | STYLE1);


        // 判断是否有 相同为1 ， 否则为0 。 相同为1 ，否则为0 。  表示存在
        System.out.println((3 & STYLE1) > 0); // 是否存在 ！=0 表示存在
        // 移出状态

        // 不同为1 ，否则为0
        System.out.println(12 ^ STYLE4);
    }

}
