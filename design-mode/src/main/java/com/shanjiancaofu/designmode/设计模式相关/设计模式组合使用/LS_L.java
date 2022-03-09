package com.shanjiancaofu.designmode.设计模式相关.设计模式组合使用;

public class LS_L extends AbstractLS {
    protected String echo(CommandVO vo) {
        return FileManager.ls_l(vo.getCommandName());
    }

    //l选项
    protected String getOperateParam() {
        return super.L_PARAM;
    }
}
