package com.shanjiancaofu.designmode.设计模式相关.责任链和观察者模式.责任链模式;

public class TopDnsServer extends DnsServer {
    @Override
    protected Recorder echo(String domain) {
        Recorder recorder = super.echo(domain);
        recorder.setOwner("全球顶级DNS服务器");
        return recorder;
    }

    @Override
    protected boolean isLocal(String domain) {
        //所有的域名最终的解析地点
        return true;
    }
}
