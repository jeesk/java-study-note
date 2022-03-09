package com.shanjiancaofu.designmode.设计模式相关._19state;

/**
 * 空闲状态
 * @author Administrator
 *
 */
public class FreeState implements State {

	@Override
	public void handle() {
		System.out.println("房间空闲！！！没人住！");
	}

}
