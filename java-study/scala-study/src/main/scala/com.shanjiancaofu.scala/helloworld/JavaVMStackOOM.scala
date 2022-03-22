package com.shanjiancaofu.scala.helloworld

/**
 * VM参数  -Xss2m
 */
object JavaVMStackOOM {
    def main(arges: Array[String]): Unit = {
        while (true)
            new Thread(() => {
                while (true) {}
            }).start()

    }
}
