package com.shanjiancaofu.designmode.设计模式相关._2工厂模式.abstractFactory;

//抽象产品（Bmw和Audi同理）
abstract class BenzCar {
    private String name;

    public abstract void drive();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//具体产品（Bmw和Audi同理）
class BenzSportCar extends BenzCar {
    public void drive() {
        System.out.println(this.getName() + "----BenzSportCar-----------------------");
    }
}

class BenzBusinessCar extends BenzCar {
    public void drive() {
        System.out.println(this.getName() + "----BenzBusinessCar-----------------------");
    }
}

abstract class BmwCar {
    private String name;

    public abstract void drive();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class BmwSportCar extends BmwCar {
    public void drive() {
        System.out.println(this.getName() + "----BmwSportCar-----------------------");
    }
}

class BmwBusinessCar extends BmwCar {
    public void drive() {
        System.out.println(this.getName() + "----BmwBusinessCar-----------------------");
    }
}

abstract class AudiCar {
    private String name;

    public abstract void drive();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class AudiSportCar extends AudiCar {
    public void drive() {
        System.out.println(this.getName() + "----AudiSportCar-----------------------");
    }
}

class AudiBusinessCar extends AudiCar {
    public void drive() {
        System.out.println(this.getName() + "----AudiBusinessCar-----------------------");
    }
}


//抽象工厂
abstract class Driver3 {
    public abstract BenzCar createBenzCar(String car) throws Exception;

    public abstract BmwCar createBmwCar(String car) throws Exception;

    public abstract AudiCar createAudiCar(String car) throws Exception;
}

//具体工厂
class SportDriver extends Driver3 {
    public BenzCar createBenzCar(String car) throws Exception {
        return new BenzSportCar();
    }

    public BmwCar createBmwCar(String car) throws Exception {
        return new BmwSportCar();
    }

    public AudiCar createAudiCar(String car) throws Exception {
        return new AudiSportCar();
    }
}

// 具体工厂
class BusinessDriver extends Driver3 {
    public BenzCar createBenzCar(String car) throws Exception {
        return new BenzBusinessCar();
    }

    public BmwCar createBmwCar(String car) throws Exception {
        return new BmwBusinessCar();
    }

    public AudiCar createAudiCar(String car) throws Exception {
        return new AudiBusinessCar();
    }
}

//老板
public class BossAbstractFactory {

    public static void main(String[] args) throws Exception {

        Driver3 d = new BusinessDriver();
        AudiCar car = d.createAudiCar("");

        car.drive();
    }
}


// 抽象工厂和工厂方法的不同之处， 在于， 抽象工厂把工厂抽象了，同时也把具体的产品抽象了， 每一层可以看成一个族
// 比如说， 商业工厂和运动工厂抽象了。 奥迪和宝马 车被抽象了一层。
