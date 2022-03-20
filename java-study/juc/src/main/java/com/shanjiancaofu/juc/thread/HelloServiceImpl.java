/*
package com.shanjiancaofu.juc.thread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class HelloServiceImpl implements HelloService {


//    private final Logger log = LoggerFactory.getLogger(HelloServiceImpl.class);

    private AtomicInteger r = new AtomicInteger(0);

    @Transactional
    @Override
    public void sayHello(long timeMillis) {

        long time = System.currentTimeMillis() - timeMillis;
        if (time > 5000) {
            //超过5秒的打印日志输出
            //log.warn("time : {}", time);
            System.out.println("超时了" );
             //超过5秒的打印日志输出

        } else {
           System.out.println("没有超时" + time + "  AtomicInteger: " + r.incrementAndGet());
        }
        //print();
        try {
            //模拟业务执行时间为1s
            Thread.sleep(1000);
          //  System.out.println("模拟业务执行时间为1s" + "  AtomicInteger: " + r.incrementAndGet());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
*/
