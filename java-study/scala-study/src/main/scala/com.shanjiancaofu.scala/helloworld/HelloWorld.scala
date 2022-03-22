package com.shanjiancaofu.scala.helloworld

/**
 * -Xms2m -Xmx2m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D://123.hprof
 */
object HelloWorld {
    def main(argrs :Array[String]):Unit= {
        println("hello world from scala")
        System.out.println("hello world from java")
    }
}
