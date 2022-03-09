package com.shanjiancaofu.designmode.设计模式相关._14mediator;

public interface Mediator {

	void register(String dname, Department d);

	void command(String dname);

}
