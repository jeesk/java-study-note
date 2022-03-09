package com.shanjiancaofu.designmode.设计模式相关.规格模式.增强版本.增强版本;

import com.shanjiancaofu.designmode.设计模式相关.规格模式.User;

import java.util.ArrayList;

class Client3 {
    public static void main(String[] args) {
//首先初始化一批用户
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(new User("苏国庆", 23));
        userList.add(new User("国庆牛", 82));
        userList.add(new User("张国庆三", 10));
        userList.add(new User("李四", 10));
//定义一个用户查询类
        IUserProvider userProvider = new UserProvider(userList);
//打印出名字包含"国庆"的人员
        System.out.println("===名字包含国庆的人员===");
//定义一个规格书
        IUserSpecification spec = new UserByAgeThan(25);
        IUserSpecification spec2 = new UserByNameLike("%国庆%");

        //  and 或者是Or , 表示 将两个的判断放在一起作为返回, 然后构造一个新的接口
        // 将 2个接口的isSafety 放在一起判断即可.

        for (User u : userProvider.findUser(spec.and(spec2))) {
            System.out.println(u);
        }
    }
}

public class Client {
    public static void main(String[] args) {
//首先初始化一批用户
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(new User("苏大", 3));
        userList.add(new User("牛二", 8));
        userList.add(new User("张三", 10));
        userList.add(new User("李四", 15));
        userList.add(new User("王五", 18));
        userList.add(new User("赵六", 20));
        userList.add(new User("马七", 25));
        userList.add(new User("杨八", 30));
        userList.add(new User("侯九", 35));
        userList.add(new User("布十", 40));
//定义一个用户查询类
        IUserProvider userProvider = new UserProvider(userList);
//打印出年龄大于20岁的用户
        System.out.println("===年龄大于20岁的用户===");
//定义一个规格书
        IUserSpecification userSpec = new UserByAgeThan(20);
        for (User u : userProvider.findUser(userSpec)) {
            System.out.println(u);
        }
    }
}


class Client1 {
    public static void main(String[] args) {
//首先初始化一批用户
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(new User("苏国庆", 23));
        userList.add(new User("国庆牛", 82));
        userList.add(new User("张国庆三", 10));
        userList.add(new User("李四", 10));
//定义一个用户查询类
        IUserProvider userProvider = new UserProvider(userList);
//打印出名字包含"国庆"的人员
        System.out.println("===名字包含国庆的人员===");
//定义一个规格书
        IUserSpecification userSpec = new UserByNameLike("%国庆");
        for (User u : userProvider.findUser(userSpec)) {
            System.out.println(u);
        }
    }
}


