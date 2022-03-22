package com.shanjiancaofu.structure.loaderbalance;

import java.util.HashMap;
import java.util.Map;

public class ServerIps {
	static final Map<String, Integer> WEIGHT_LIST = new HashMap<String, Integer>();

	static {
		WEIGHT_LIST.put("A", 2);
		WEIGHT_LIST.put("B", 5);
		WEIGHT_LIST.put("C", 1);
		WEIGHT_LIST.put("D", 1);
		WEIGHT_LIST.put("E", 5);
	}

	{

		// 权重之和为50
//        WEIGHT_LIST.put("192.168.0.1", 1);
//        WEIGHT_LIST.put("192.168.0.2", 8);
//        WEIGHT_LIST.put("192.168.0.3", 3);
//        WEIGHT_LIST.put("192.168.0.4", 6);
//        WEIGHT_LIST.put("192.168.0.5", 5);
//        WEIGHT_LIST.put("192.168.0.6", 5);
//        WEIGHT_LIST.put("192.168.0.7", 4);
//        WEIGHT_LIST.put("192.168.0.8", 7);
//        WEIGHT_LIST.put("192.168.0.9", 2);
//        WEIGHT_LIST.put("192.168.0.10", 9);

	}
}

