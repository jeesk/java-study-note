package com.shanjiancaofu.designmode.设计模式相关;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class Element {
    public abstract void accept(IVisitor visitor);

    public abstract void doSomething();
}

class ConcreteElement1 extends Element {
    public void doSomething() {
        System.out.println("这是元素1");
    }

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

class ConcreteElement2 extends Element {
    public void doSomething() {
        System.out.println("这是元素2");
    }

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

interface IVisitor {
    public void visit(ConcreteElement1 el1);

    public void visit(ConcreteElement2 el2);
}

class Visitor implements IVisitor {
    public void visit(ConcreteElement1 el1) {
        el1.doSomething();
    }

    public void visit(ConcreteElement2 el2) {
        el2.doSomething();
    }
}

class ObjectStruture {
    public static List<Element> getList() {
        List<Element> list = new ArrayList<Element>();
        Random ran = new Random();


        for (int i = 0; i < 10; i++) {
            int a = ran.nextInt(100);
            if (a > 50) {
                list.add(new ConcreteElement1());
            } else {
                list.add(new ConcreteElement2());
            }
        }
        return list;
    }
}

public class 访问者模式 {
    public static void main(String[] args) {
        List<Element> list = ObjectStruture.getList();

        // 不同的的元素， 实现不同的访问。
        // 当元素调用访问的方法的时候， 使用Visitver去调用， 而visterver.visit(); 的方法可以重载， 这个时候就可惜区分不同的元素 。

        for (Element element : list) {
            element.accept(new Visitor());
        }

    }
}
