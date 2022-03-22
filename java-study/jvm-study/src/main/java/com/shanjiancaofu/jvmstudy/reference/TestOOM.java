package com.shanjiancaofu.jvmstudy.reference;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
// -Xms2M -Xmx3M
public class TestOOM {
	private static List<Object> list = new ArrayList<>();
	public static void main(String[] args) {
		testSoftReference();
	}
	private static void testSoftReference() {
		byte[] buff = null;

		for (int i = 0; i < 10; i++) {
			buff = new byte[1024 * 1024];
			SoftReference<byte[]> sr = new SoftReference<>(buff);
			list.add(sr);
		}

		System.gc(); //主动通知垃圾回收

		for(int i=0; i < list.size(); i++){
			Object obj = ((SoftReference) list.get(i)).get();
			System.out.println(obj);
		}

		System.out.println("buff: " + buff.toString());
	}

}
