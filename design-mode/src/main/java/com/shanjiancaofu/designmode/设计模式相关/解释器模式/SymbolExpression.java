package com.shanjiancaofu.designmode.设计模式相关.解释器模式;

public abstract class SymbolExpression extends Expression {
    protected Expression left;
    protected Expression right;

    //所有的解析公式都应只关心自己左右两个表达式的结果
    public SymbolExpression(Expression _left, Expression _right) {
        this.left = _left;
        this.right = _right;
    }
}
