package com.shanjiancaofu.jvmstudy.gc;

/**
 * 测试MinorGC
 * 在控制台看Gc  -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 * 在日志文件里面看GC  -Xms20m -Xmx20m -Xmn10m  -XX:SurvivorRatio=8 -XX:GCLogFileSize=30m -Xloggc:mxs.log
 */
public class MinorGCTest {
	public static final int _1MB = 1024 * 1024;
	public static void main(String[] args) {
		byte[] byte1, byte2, byte3, byte4;
		byte1 = new byte[2* _1MB];
		byte2 = new byte[2*_1MB];
		byte3 = new byte[2*_1MB];
		byte4 = new byte[4 *_1MB];
	}
}
