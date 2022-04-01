package com.shanjiancaofu.annotion.rentaion;

import lombok.NonNull;

public class TestLombokNotNull {
	public static void main(String[] args) {
		System.out.println("124");
		print(null);
	}
	public static void print(@NonNull String msg){
		System.out.println(msg);
	}
}
