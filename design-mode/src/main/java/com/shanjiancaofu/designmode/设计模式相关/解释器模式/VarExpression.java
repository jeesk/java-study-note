package com.shanjiancaofu.designmode.设计模式相关.解释器模式;

import java.util.HashMap;

public class VarExpression extends Expression {
    private String key;

    public VarExpression(String _key) {
        this.key = _key;
    }

    //从中取之

    public int interpreter(HashMap<String, Integer> var) {
        return var.get(this.key);
    }
}


