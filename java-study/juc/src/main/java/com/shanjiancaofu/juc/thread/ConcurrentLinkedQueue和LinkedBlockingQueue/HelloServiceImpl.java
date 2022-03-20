package com.shanjiancaofu.juc.thread.ConcurrentLinkedQueue和LinkedBlockingQueue;


public class HelloServiceImpl implements HelloService {


//    private final Logger log = LoggerFactory.getLogger(HelloServiceImpl.class);


    // @Transactional

    @Override

    public void sayHello(long timeMillis) {

        long time = System.currentTimeMillis() - timeMillis;
        if (time > 5000) {
            //超过5秒的打印日志输出
            //log.warn("time : {}", time);
            System.out.println(time);
        }
        try {
            //模拟业务执行时间为1s
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
