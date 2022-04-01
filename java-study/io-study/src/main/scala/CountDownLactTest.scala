import java.util
import java.util.concurrent.{CountDownLatch, Executors}

object CountDownLactTest {
    def main(args: Array[String]): Unit = {
        val countDownLatch = new CountDownLatch(1)
        val executors = Executors.newFixedThreadPool(100)
        var count  = 10
        val list = new util.ArrayList[Object]()
        while (count > 0) {
            executors.submit(new Runnable {
                override def run(): Unit = {
                    countDownLatch.countDown()
                    println("你好")
                }
            })
            count -=1
        }

        countDownLatch.await()
        println(list)
    }
}
