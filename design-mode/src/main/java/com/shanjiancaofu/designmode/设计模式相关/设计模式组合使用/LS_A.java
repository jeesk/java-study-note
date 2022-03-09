package com.shanjiancaofu.designmode.设计模式相关.设计模式组合使用;

public class LS_A extends AbstractLS {
//ls -a命令
protected String echo(CommandVO vo) {
return FileManager.ls_a(vo.getCommandName());
}
protected String getOperateParam() {
return super.A_PARAM;
}
}
