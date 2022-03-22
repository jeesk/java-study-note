package com.shanjiancaofu.designmode.设计模式相关._3builder;

public class Client {
	public static void main(String[] args) {

		AirShipDirector director = new SxtAirshipDirector(new SxtAirShipBuilder());

		AirShip ship = director.directAirShip();

		System.out.println(ship.getEngine().getName());

		ship.launch();

	}
}
