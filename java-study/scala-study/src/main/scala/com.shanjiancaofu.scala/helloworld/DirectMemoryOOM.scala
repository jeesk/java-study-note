package com.shanjiancaofu.scala.helloworld

import sun.misc.Unsafe

/**
 * VM 参数 -Xmx20M -XX:MaxDirectMemorySize=10M
 */
object DirectMemoryOOM {
    def main(args: Array[String]): Unit = {
        val filed = classOf[Unsafe].getDeclaredFields()(0)
        filed.setAccessible(true)
        val unsafe = filed.get(null).asInstanceOf[Unsafe]
        while (true){
            unsafe.allocateMemory(1024 * 1024)
        }
    }
}
