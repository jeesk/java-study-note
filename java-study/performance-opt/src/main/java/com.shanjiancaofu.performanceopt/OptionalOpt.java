package com.shanjiancaofu.performanceopt;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalOpt {
	public static void main(String[] args) {
		String s = "1243";
		// 当 s  不为空的时间也会调用 getStr() 方法没有延迟执行
		Optional.of(s).orElse(getStr());
		// 当 s  不为空的时间不会调用 getStr() 有延迟执行
		Optional.of(s).orElseGet(() -> getStr());

	}

	public static String getStr(){
		return "1234" + "hello";
	}
}
