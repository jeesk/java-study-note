package com.shanjiancaofu.annotion;

public class GFG {

    private static final class Demo { }
    public static void main(String args[])
    {
		System.out.println(GFG.Demo.class.isSynthetic());
		Demo demo = new Demo();
		System.out.println(demo.getClass().isSynthetic());
		System.out.println(new GFG().getClass().isSynthetic());
	}
}
