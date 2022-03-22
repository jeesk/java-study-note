package com.shanjiancaofu.scala.helloworld

import java.util

/**
 * jdk8以上  -XX:MaxMetaspaceSize=10m -XX:MetaspaceSize=10m
 * jdk8以下  -XX:MaxPermSize=10m -XX:PermSize=10m
 */
object RuntimeConstantPoolOOM {
    def main(args : Array[String]):Unit = {
        val list = new util.ArrayList[String]()
        var count = 0
        while (true){
            list.add(String.valueOf(count+"hellowordhellowordhellowordhellowordhellowordhelloword").intern())
            count = count +1
        }
    }
}
