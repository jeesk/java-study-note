package com.shanjiancaofu.scala.helloworld

class FinalizeEscapeGC(){
    var fgc : FinalizeEscapeGC = _
    def isAlive :Unit= {
        println("yes I'm alive")
    }
    override def finalize(): Unit = {
        super.finalize()
        println("finalize method executed！")

    }
}

object FinalizeEscapeGC {
    def main(args: Array[String]): Unit = {
       var  finalizeEscapeGC = new FinalizeEscapeGC
        var finalizeEscapeGC2 = new FinalizeEscapeGC
        finalizeEscapeGC.fgc = finalizeEscapeGC2
        finalizeEscapeGC.fgc =null
        System.gc()
        Thread.sleep(500)
        if(finalizeEscapeGC.fgc != null){
            finalizeEscapeGC.fgc.isAlive
        }else{
            println("i am dead")
        }
        // 相同的代码， 逃逸失败
        finalizeEscapeGC.fgc =null
        System.gc()
        Thread.sleep(500)
        if(finalizeEscapeGC.fgc != null){
            finalizeEscapeGC.fgc.isAlive
        }else{
            println("i am dead")
        }
    }
}
