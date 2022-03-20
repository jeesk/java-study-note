package com.shanjiancaofu.effctiveJava.genertictype;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GeneticDemo {
    /**
     * 泛型普通方法方法  一般在public 后面申明泛型的类型
     */
    public <T> void getT(T t) {
    }

    /**
     * 泛型的静态方法
     */
    public static <T> void getGenertic(T t) {
    }

    /**
     *  如果一个类中有多个静态方法,那么可以将泛型申明到类上面去,凡是静态方法必须在自己的方法上面申明泛型.
     *  静态方法的泛型申明在static之后,在返回值之前.
     */
    /**
     * 泛型中? 和T的区别
     * 参数中的泛型申明为? 表示为任何类型, 如果为T那么只能事同一种类型
     */
    public static <T> void show1(List<T> list) {
        for (Object object : list) {
            System.out.println(object.toString());
        }
    }

    public static void show2(List<?> list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }

    @Test
    public void test() {
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("zhangsan", 18, 0));
        list1.add(new Student("lisi", 28, 0));
        list1.add(new Student("wangwu", 24, 1));
        //这里如果add(new Teacher(...));就会报错，因为我们已经给List指定了数据类型为Student
        show1(list1);

        System.out.println("************分割线**************");

        //这里我们并没有给List指定具体的数据类型，可以存放多种类型数据
        List list2 = new ArrayList<>();
        list2.add(new Student("zhaoliu", 22, 1));
        list2.add(new Person("sunba", 30, 0));
        show2(list2);
    }

    /**
     * 泛型的边界问题 上界: 最高只能是Person:一般作为生产者
     */

    public static void show3(List<? extends Person> list) {

        for (Object object : list) {
            System.out.println(object);
        }
    }


    @Test
    public void testSHOW3() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person());
        show3(personList);

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student());
        show3(studentList);
    }


    public void upperBound(List<? extends Date> list, Date date) {
        Date now = list.get(0);
        System.out.println("now==>" + now);
        //list.add(date); //这句话无法编译
        list.add(null);//这句可以编译，因为null没有类型信息
    }

    @Test
    public void testUpperBound() {
        List<Timestamp> list = new ArrayList<>();
        Date date = new Date();

        // 为什么回报错呢, List<TimeStamp> 里面是不可能放入Date类型的
      // upperBound(list, date);
    }

    @Test
    public void testUpperBound1() {
        List<Timestamp> list = new ArrayList<>();
        Date date = new Date();
    //    upperBound(list, date);


    }


    public <T extends Date> void upperBound2(List<T> list, T date)
    {
        list.add(date);
    }

    // 泛型的上限和下限的问题可以参考Colections.copy



}
