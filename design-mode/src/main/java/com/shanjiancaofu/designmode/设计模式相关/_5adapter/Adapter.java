package com.shanjiancaofu.designmode.设计模式相关._5adapter;

/**
 * 适配器 (类适配器方式)
 * (相当于usb和ps/2的转接器)
 * @author Administrator
 *
 */
public class Adapter extends Adaptee implements Target {


	@Override
	public void handleReq() {
		super.request();
	}

}
