package com.shanjiancaofu.designmode.设计模式相关.门面模式;

//   只暴露接口,调用者不需要注重细节



public interface ILetterProcess {
    //首先要写信的内容
    public void writeContext(String context);

    //其次写信封
    public void fillEnvelope(String address);

    //把信放到信封里
    public void letterInotoEnvelope();

    //然后邮递
    public void sendLetter();
}

class LetterProcessImpl implements ILetterProcess {
    //写信
    public void writeContext(String context) {
        System.out.println("填写信的内容..." + context);
    }

    //在信封上填写必要的信息
    public void fillEnvelope(String address) {
        System.out.println("填写收件人地址及姓名..." + address);
    }

    //把信放到信封中，并封好
    public void letterInotoEnvelope() {
        System.out.println("把信放到信封中...");
    }

    //塞到邮箱中，邮递
    public void sendLetter() {
        System.out.println("邮递信件...");
    }
}

class ModenPostOffice {
    private ILetterProcess letterProcess = new LetterProcessImpl();

    //写信，封装，投递，一体化
    public void sendLetter(String context, String address) {
        //帮你写信
        letterProcess.writeContext(context);
        //写好信封
        letterProcess.fillEnvelope(address);
        //把信放到信封中
        letterProcess.letterInotoEnvelope();
        //邮递信件
        letterProcess.sendLetter();
    }
}

class Client2 {
    public static void main(String[] args) {
        //现代化的邮局，有这项服务，邮局名称叫Hell Road
        ModenPostOffice hellRoadPostOffice = new ModenPostOffice();

        //你只要把信的内容和收信人地址给他，他会帮你完成一系列的工作
        //定义一个地址
        String address = "Happy Road No. 666,God Province,Heaven";
        //信的内容
        String context = "Hello,It's me,do you know who I am? I'm your old lover. //你给我发送吧";
        hellRoadPostOffice.sendLetter(context, address);


        //  减少系统之间的相与 依赖。
        //  外界 访问提供一个公共的接口即可。
        // 当门面多的时候， 可以考虑，将多个门的接口， 放在一个总的门面接口中， 使用组合的方式， 来组合各个门面。







    }
}

class Police {
    //检查信件，检查完毕后警察在信封上盖个戳：此信无病毒
    public void checkLetter(ILetterProcess letterProcess) {
        System.out.println(letterProcess + " 信件已经检查过了...");
    }
}

class ModenPostOffice2 {
    private ILetterProcess letterProcess = new LetterProcessImpl();
    private Police letterPolice = new Police();

    //写信，封装，投递，一体化了
    public void sendLetter(String context, String address) {
        //帮你写信
        letterProcess.writeContext(context);
        //写好信封
        letterProcess.fillEnvelope(address);
        //警察要检查信件了
        letterPolice.checkLetter(letterProcess);
        //把信放到信封中
        letterProcess.letterInotoEnvelope();
        //邮递信件
        letterProcess.sendLetter();
    }
}

// 代理类
class Client {
    public static void main(String[] args) {
        //创建一个处理信件的过程
        ILetterProcess letterProcess = new LetterProcessImpl();
        //开始写信
        letterProcess.writeContext("Hello,It's me,do you know who I am? I'm //开始写信封");
        letterProcess.fillEnvelope("Happy Road No. 666,God Province,Heaven");
        //把信放到信封里，并封装好
        letterProcess.letterInotoEnvelope();
        //跑到邮局把信塞到邮箱，投递
        letterProcess.sendLetter();
    }
}
