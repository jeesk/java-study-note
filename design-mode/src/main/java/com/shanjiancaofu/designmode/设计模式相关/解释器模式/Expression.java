package com.shanjiancaofu.designmode.设计模式相关.解释器模式;

import java.util.HashMap;

public abstract class Expression {
    abstract int interpreter(HashMap<String, Integer> var);
}
