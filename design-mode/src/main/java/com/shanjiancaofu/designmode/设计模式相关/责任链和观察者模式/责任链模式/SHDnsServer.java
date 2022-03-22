package com.shanjiancaofu.designmode.设计模式相关.责任链和观察者模式.责任链模式;

public class SHDnsServer extends DnsServer {
    @Override
    protected Recorder echo(String domain) {
        Recorder recorder = super.echo(domain);
        recorder.setOwner("上海DNS服务器");
        return recorder;
    }

    //定义上海的DNS服务器能处理的级别
    @Override
    protected boolean isLocal(String domain) {
        return domain.endsWith(".sh.cn");
    }
}
