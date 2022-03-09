package com.shanjiancaofu.designmode.设计模式相关.责任链和观察者模式.观察者模式;

import com.shanjiancaofu.designmode.设计模式相关.责任链和观察者模式.责任链模式.Recorder;

public class TopDnsServer extends DnsServer {
    @Override
    protected void sign(Recorder recorder) {
        recorder.setOwner("全球顶级DNS服务器");
    }

    @Override
    protected boolean isLocal(Recorder recorder) {
//所有的域名最终的解析地点
        return true;
    }
}
