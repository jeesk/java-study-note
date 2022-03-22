package com.shanjiancaofu.designmode.设计模式相关._21memento;

public class Client {
    public static void main(String[] args) {
        CareTaker taker = new CareTaker();


        Emp emp = new Emp("高淇", 18, 900);
        System.out.println("第一次打印对象：" + emp.getEname() + "---" + emp.getAge() + "---" + emp.getSalary());

        taker.setMemento(emp.memento());   //备忘一次

        emp.setAge(38);
        emp.setEname("搞起");
        emp.setSalary(9000);
        System.out.println("第二次打印对象：" + emp.getEname() + "---" + emp.getAge() + "---" + emp.getSalary());

        emp.recovery(taker.getMemento()); //恢复到备忘录对象保存的状态

        System.out.println("第三次打印对象：" + emp.getEname() + "---" + emp.getAge() + "---" + emp.getSalary());

        // 备忘录模式， 通过备忘录管理对象，管理要备忘的东西。 要恢复的时候， 直接恢复内容即可。

        //   不仅如此 ， 要备忘的对象还可以放在， 对象 里面。
        // 要创建备份的时候， 直接使用clone方法，备份即可。
        // 要恢复的话直接，备份的东西设置到当前类中即可。

    /*Clone 方式的备忘录模式，可以使用在比较简单的场景或者比较单一的场景
        中，尽量不要与其他的对象产生严重的耦合关系。*/


    // 具体实现中， 只有发起者自己才能 操作数据 ， 这个时候 ， 可以 将数据以内部类的形式存储。
        //  可以 提供双接口， 外部类有一个接口， 内部 类有一个接口。

        // 内置类Memento  全部是  private的访问权限，也就是说除了发起人外，别人休想访问到，

        //那如果要产生关联关系又应如何处理呢？通过接口！ 给内部类设置一个接口，然后，



    }
}
