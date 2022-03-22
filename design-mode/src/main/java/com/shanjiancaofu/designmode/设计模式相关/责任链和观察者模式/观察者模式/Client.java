package com.shanjiancaofu.designmode.设计模式相关.责任链和观察者模式.观察者模式;

import com.shanjiancaofu.designmode.设计模式相关.责任链和观察者模式.责任链模式.Recorder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client {
    public static void main(String[] args) throws Exception {
        //上海域名服务器
        DnsServer sh = new SHDnsServer();
        //中国顶级域名服务器
        DnsServer china = new ChinaTopDnsServer();
        //全球顶级域名服务器
        DnsServer top = new TopDnsServer();
        //定义查询路径
        china.setUpperServer(top);  // 增加观察者
        sh.setUpperServer(china);// 增加观察者
        //解析域名
        System.out.println("=====域名解析模拟器=====");


        // 使用观察者模式的变化是, 起点是一样的, 但是背后是谁在真正处理的, 这个就不一定了


        while (true) {
            System.out.print("\n请输入域名(输入N退出):");
            String domain = (new BufferedReader(new InputStreamReader(System.in))).readLine();
            if (domain.equalsIgnoreCase("n")) {
                return;
            }
            Recorder recorder = new Recorder();
            recorder.setDomain(domain);
            sh.update(null, recorder);
            System.out.println("----DNS服务器解析结果----");
            System.out.println(recorder);
        }
    }
}
