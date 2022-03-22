package com.shanjiancaofu.jvmstudy.multistatus;

public class MultiSatusDemo {
	public static void main(String[] args) {
		Animal man = new Man();
		Animal woman = new Woman();
		man.say();
		woman.say();
	}

	/**
	 * 有抽象方法一定是抽象类，抽象类不一定有抽象方法
	 */
	public abstract static class Animal{

		public void say(){
			System.out.println("Hello animal");
		}

			}

	public static class Man extends Animal{
		@Override
		public void say() {
			System.out.println("hello women");
		}
	}

	public static class Woman extends Animal{
		@Override
		public void say() {
			System.out.println("hello man");
		}
	}
}
