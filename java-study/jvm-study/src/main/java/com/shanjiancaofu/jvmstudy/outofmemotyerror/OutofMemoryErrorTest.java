package com.shanjiancaofu.jvmstudy.outofmemotyerror;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用jvm 参数模拟 OutofMemoryError
 * -Xms2m -Xmx2m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D://123.hprof
 *  或者使用 jmap -dump:live,format=b,file=m.hprof PID    PID为进程号
 */
public class OutofMemoryErrorTest {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		while (true){
			strings.add("hello world");
		}
	}
}
