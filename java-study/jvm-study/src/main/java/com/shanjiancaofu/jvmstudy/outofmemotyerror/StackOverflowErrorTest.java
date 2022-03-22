package com.shanjiancaofu.jvmstudy.outofmemotyerror;

/**
 * 使用jvm 参数  -Xss128k
 */
public class StackOverflowErrorTest
{
	public static void main(String[] args) {
		set();
	}

	public static final void set(){
		set();
	}
}
