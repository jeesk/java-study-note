package com.shanjiancaofu.designmode.设计模式相关.责任链设计模式;

public interface Filter {
	void doFilter(Request request, Response response, FilterChain chain);
}
