package com.shanjiancaofu.designmode.设计模式相关.设计模式组合使用;

public class Invoker {
    //执行命令
    public String exec(String _commandStr) {
//定义返回值
        String result = "";
//首先解析命令
        CommandVO vo = new CommandVO(_commandStr);


        //检查是否支持该命令
        if (CommandEnum.getNames().contains(vo.getCommandName())) {
            //产生命令对象
            CommandEnum commandEnum = CommandEnum.valueOf(vo.getCommandName());
            String className = CommandEnum.valueOf(vo.getCommandName()).getValue();
            Command command;
            try {
                command = (Command) Class.forName(className).newInstance();
                result = command.execute(vo);
            } catch (Exception e) {
// TODO 异常处理
            }
        } else {
            result = "无法执行命令，请检查命令格式";
        }
        return result;
    }
}
