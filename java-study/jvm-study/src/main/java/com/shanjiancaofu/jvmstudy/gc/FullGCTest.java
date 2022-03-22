package com.shanjiancaofu.jvmstudy.gc;
/**
 * 测试MinorGC
 * 在控制台看Gc
 * -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8  -XX:+UseParNewGC -XX:HandlePromotionFailure=true
 *
 * 在日志文件里面看GC -Xms20m -Xmx20m -Xmn10m  -XX:SurvivorRatio=8 -XX:GCLogFileSize=30m -Xloggc:mxs.log XX:+UseParNewGC -XX:PretenureSizeThreshold=3145728
 *
 * //  由于在jdk 8 默认使用Parallel Scavenge + Parallel Old， 已经被自动优化了，-XX:PretenureSizeThreshold=3145728 和-XX:SurvivorRatio=8 无效使用 所以要指定ParNewGc
 */
public class FullGCTest {
	public static final int _1MB = 1024 * 1024;
	public static void main(String[] args) {


		byte[] byte1, byte2, byte3, byte4,byte5,byte6,byte7;
		byte1 = new byte[2 * _1MB];
		byte2 = new byte[2 * _1MB];
		byte3 = new byte[2 * _1MB];
		byte1 = null;

		byte4 = new byte[2 * _1MB];
		byte5 = new byte[2 * _1MB];
		byte6 = new byte[2 * _1MB];

		byte4 = null;
		byte5= null;
		byte6 = null;
		byte7 = new byte[2 * _1MB];
	}
}
