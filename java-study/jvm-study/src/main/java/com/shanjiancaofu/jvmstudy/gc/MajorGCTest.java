package com.shanjiancaofu.jvmstudy.gc;

/**
 * 测试MinorGC
 * 在控制台看Gc
 * -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728 -XX:+UseParNewGC
 *
 * 在日志文件里面看GC -Xms20m -Xmx20m -Xmn10m  -XX:SurvivorRatio=8 -XX:GCLogFileSize=30m -Xloggc:mxs.log XX:+UseParNewGC -XX:PretenureSizeThreshold=3145728
 *
 * //  由于在jdk 8 默认使用Parallel Scavenge + Parallel Old， 已经被自动优化了，-XX:PretenureSizeThreshold=3145728 和-XX:SurvivorRatio=8 无效使用 所以要指定ParNewGc
 */
public class MajorGCTest {
	public static final int _1MB = 1024 * 1024;
	public static void main(String[] args) {
		byte[] byte4;
		byte4 = new byte[5 *_1MB];
	}
}
