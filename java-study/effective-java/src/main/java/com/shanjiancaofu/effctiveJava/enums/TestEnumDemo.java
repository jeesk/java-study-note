package com.shanjiancaofu.effctiveJava.enums;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

enum Operation {


	ONE("+") {
		double apply(double a, double a2) {
			return 1;
		}
	},

	TWO("-") {
		double apply(double a, double a2) {
			return 2;
		}
	};

	// 枚举里面的valueOf要依靠toString方法， 如果覆写了toString方法，  那么valueOf方法将会失效
	// 枚举里面使用ValueOf(),  使用常量的名字，转换成常量的本身
	// 所以说要复写一个fromString方法, 代替ValufOf方法才行
	// 枚举里面的申明常量，相当于创建枚举类型的对象，也可心在申明常量的时候使用枚举的构造器


	private String sign;
	private static final Map<String, Operation> map = new HashMap<>();

	public Operation fromString(String symbol) {
		return map.get(symbol);
	}

	static {

		for (Operation value : values()) {
			map.put(value.toString(), value);
		}
	}

	Operation(String sign) {
		this.sign = sign;
	}


	abstract double apply(double a, double a2);


	Operation() {

	}


}


public class TestEnumDemo {
	@Test
	public void tesstEnum() {
		Operation[] values = Operation.values();
		Stream<Operation> values1 = Stream.of(values);
		values1.forEach(x -> System.out.println(x));


		Operation operation = Operation.valueOf("ONE"); // 通过枚举的名字找到枚举对象自己
		System.out.println(operation);

		//  通过key 找value 可以使用静态方法来加载一次, 提高性能

	}
}
