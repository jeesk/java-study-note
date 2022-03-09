package com.shanjiancaofu.designmode.设计模式相关.观察者模式;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @Description
 * @Author 宋奇福 <meetsong@foxmail.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/9/16 23:38
 */
public class Xiaoming {

    private List<Observer> observers = new ArrayList<>();



    public void update(Observable o, Object arg) {
        //
      /*  观察者模式，
        Observer 观察者接口有用update方法用于是观察者受到消息后的动作，
        ConcreateObsert  具体的观察者

        Subject 被观察者接口， 能够动态地增加，取消，删除观察者，管理观察者，是抽象类，或者是实现类
        ConcreateSubjet 具体的被观察者实现了Subject接口

        当concreateSubject执行某件事的时候，在方法中执行父类抽象类的动作，用于执行所有的观察者的方法，这样就实现了观察者观察的动作*/

    }
}
