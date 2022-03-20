package com.shanjiancaofu.scala.helloworld

import java.util

object OutofMemoryErrorTest {
    def main(args: Array[String]): Unit = {
        val strings = new util.ArrayList[String]
        while (true) strings.add("hello world")

    }
}
