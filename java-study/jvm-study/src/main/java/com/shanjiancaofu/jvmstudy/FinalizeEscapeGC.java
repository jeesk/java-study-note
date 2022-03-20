package com.shanjiancaofu.jvmstudy;

class FinalizeEscapeGC{
	public static  FinalizeEscapeGC fgc = null;
	public void isAlive(){
		System.out.println("i am alive");
	}
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method executed");
		// 重新赋值逃逸
		fgc = this;
	}

	public static void main(String[] args) {
		fgc = new FinalizeEscapeGC();
		fgc = null;
		System.gc();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(fgc != null){
			fgc.isAlive();
		}else{
			System.out.println("i am dead");
		}
		// 相同的代码， 逃逸失败
		fgc = null;
		System.gc();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(fgc != null){
			fgc.isAlive();
		}else{
			System.out.println("i am dead");
		}
	}
}

