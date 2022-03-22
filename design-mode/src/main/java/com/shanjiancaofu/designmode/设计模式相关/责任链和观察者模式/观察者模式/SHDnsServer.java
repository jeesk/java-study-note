package com.shanjiancaofu.designmode.设计模式相关.责任链和观察者模式.观察者模式;

import com.shanjiancaofu.designmode.设计模式相关.责任链和观察者模式.责任链模式.Recorder;

public class SHDnsServer extends DnsServer {
    @Override
    protected void sign(Recorder recorder) {
        recorder.setOwner("上海DNS服务器");
    }

    //定义上海的DNS服务器能处理的级别
    @Override
    protected boolean isLocal(Recorder recorder) {
        return recorder.getDomain().endsWith(".sh.cn");
    }
}
