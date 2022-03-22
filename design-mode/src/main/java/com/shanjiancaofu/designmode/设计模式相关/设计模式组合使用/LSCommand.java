package com.shanjiancaofu.designmode.设计模式相关.设计模式组合使用;

public class LSCommand extends Command {
    public String execute(CommandVO vo) {
        //返回链表的首节点
        CommandName firstNode = super.buildChain(AbstractLS.class).get(0);
        return firstNode.handleMessage(vo);
    }
}
