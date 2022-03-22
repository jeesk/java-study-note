package com.shanjiancaofu.designmode.设计模式相关._3builder;

public class Directer {
    private AirShipDirector airShipDirector = new SxtAirshipDirector(new SxtAirShipBuilder());


    // 隐藏的部门可以作为拓展
   // private AirShipDirector airShipDirector = new SxtAirshipDirector(new SxtAirShipBuilder());

    public AirShip getSxtAirShip() {
        return airShipDirector.directAirShip();
    }

  /*  public AirShip getSxtAirShip() {
        return airShipDirector.directAirShip();
    }*/

}
