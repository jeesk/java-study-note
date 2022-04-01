package com.shanjiancaofu.annotion.rentaion;

public class EnCloseMethodTest {

    public Object c;
    public EnCloseMethodTest() {
        class ClassA{};
        c = new ClassA();
    }
    public Object classAObject() {
    	// 本地类（局部类）
        class ClassA{ };
        return new ClassA( );
    }
    public Runnable classWithAnonymousClass() {
    	// 匿名名
        return new Runnable() {
            public void run() {
            }
        };
    }

    public static void main(String[] args) {
        EnCloseMethodTest enCloseMethodTest = new EnCloseMethodTest();
        Class cls = enCloseMethodTest.classAObject().getClass();
        System.out.print("Local class with Method = ");
        System.out.println(cls.getEnclosingMethod());
		String s = cls.toGenericString();
		System.out.println(s);
		// Local class with Method = public java.lang.Object com.shanjiancaofu.annotion.rentaion.ClassDemo.classAObject()
        System.out.print("Anonymous class with Method = ");
        System.out.println(enCloseMethodTest.classWithAnonymousClass().getClass().getEnclosingMethod());
        // Anonymous class with Method = public java.lang.Runnable com.shanjiancaofu.annotion.rentaion.ClassDemo.classWithAnonymousClass()
    }
}
