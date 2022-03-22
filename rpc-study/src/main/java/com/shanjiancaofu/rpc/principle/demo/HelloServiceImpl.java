package com.shanjiancaofu.rpc.principle.demo;

public class HelloServiceImpl implements HelloService {

    public String sayHi(String name) {
        return "Hi, " + name;
    }

}
