package com.shanjiancaofu.designmode.设计模式相关._12chainOfResp;

/**
 * 抽象类
 * @author Administrator
 *
 */
public abstract class Leader {
	protected String name;
	protected Leader nextLeader; //责任链上的后继对象

	public Leader(String name) {
		super();
		this.name = name;
	}

	//设定责任链上的后继对象
	public void setNextLeader(Leader nextLeader) {
		this.nextLeader = nextLeader;
	}


	/**
	 * 处理请求的核心的业务方法
	 * @param request
	 */
	public abstract void handleRequest(LeaveRequest request);



}
