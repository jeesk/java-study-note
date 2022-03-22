package com.shanjiancaofu.designmode.设计模式相关.策略模式设计3;

import com.shanjiancaofu.designmode.设计模式相关.策略设计模式2.CalPrice;

@PriceRegion(max = 10000)
public class Orgnic implements CalPrice {

	@Override
	public Double calPrice(Double orgnicPrice) {
		return orgnicPrice;
	}
}
