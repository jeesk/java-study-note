package com.shanjiancaofu.scala.helloworld


class Student(name :String,var age:Int){
    def printInfo():Unit= {
        println(name +" " + age + Student.school)
    }
}

object Student {

    val school  :String = "new school"
    def main(args : Array[String]):Unit = {

        def main(args: Array[String]): Unit = {

        }



        val aclice = new Student("aloice", 12)
        val bob = new Student("bob", 12)
        aclice.printInfo()
        bob.printInfo()
    }
}
