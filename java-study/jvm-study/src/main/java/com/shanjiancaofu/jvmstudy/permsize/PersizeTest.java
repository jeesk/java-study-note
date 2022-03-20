package com.shanjiancaofu.jvmstudy.permsize;

/**
 * jdk8 去掉了  PermSize和MaxPermSize
 *  使用 -XX:MaxMetaspaceSize=128m 代替 PermSize
 *  从JDK 1.7 之后把永生代换成的元空间，把字符串常量池从方法区移到了 Java 堆上。
 */
public class PersizeTest {
	public static void main(String[] args) {

	}
}
