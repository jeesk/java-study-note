package com.shanjiancaofu.designmode.设计模式相关.责任链和观察者模式.责任链模式;

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
        china.setUpperServer(top);
        sh.setUpperServer(china);
        //解析域名
        System.out.println("=====域名解析模拟器=====");
        while (true) {
            System.out.print("\n请输入域名(输入N退出):");
            String domain = (new BufferedReader(new InputStreamReader(System.in))).readLine();
            if (domain.equalsIgnoreCase("n")) {
                return;
            }
            Recorder recorder = sh.resolve(domain);
            System.out.println("----DNS服务器解析结果----");
            System.out.println(recorder);
        }
    }
}
