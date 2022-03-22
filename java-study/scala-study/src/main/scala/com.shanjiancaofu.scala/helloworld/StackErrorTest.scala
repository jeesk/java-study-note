package com.shanjiancaofu.scala.helloworld

/**
 * Vm 参数  -Xss128k
 */
class StackErrorTest() {
    var stackLength : Int = 0
    def stackLeak(): Unit = {
        stackLength = stackLength+1
        stackLeak
    }
}
object StackErrorTest {
    def main(args: Array[String]): Unit = {
        val stackErrorTest = new StackErrorTest
        try {
            stackErrorTest.stackLeak()
        } catch {
            case  e: Throwable =>
                println(e)
                throw  e
        }
    }
}
