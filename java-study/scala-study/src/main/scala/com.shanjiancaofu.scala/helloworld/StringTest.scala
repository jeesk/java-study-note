package com.shanjiancaofu.scala.helloworld

/**
 * 在java 字符串 中 == 比软的内存地址， equals 比软的值
 * scala 中 eq是比软内存地址，== 是比较值和equals相同
 */
object StringTest {
    def main(args :Array[String]):Unit ={
        var a = "1"
        var a1 = "1"
        var a3 = new String("1")
        var a4 = new String("1").intern()
        println(a eq a3)
        println(a1 eq a3)
        println(a3 eq a4)
        println(a eq a4)
        System.gc()
        val a5 = "1"
        println(a eq a5)
    }
}
