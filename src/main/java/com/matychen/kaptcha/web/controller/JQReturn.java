package com.matychen.kaptcha.web.controller;

import java.io.Serializable;

/**
 * jQuery Ajax返回对象
 * 
 * @author cx
 * @date 2011-6-14 下午08:59:15
 */
public class JQReturn implements Serializable{

	private static final long serialVersionUID = 1L;

	public JQReturn() {
	}

	/**
	 * 是否更新成功的构造方法
	 * 
	 * @param status
	 * @param msg
	 */
	public JQReturn(boolean status, Object msg) {
		this.status = status;
		this.msg = msg;
	}

	/**
	 * 是否成功
	 */
	private boolean status;
	/**
	 * 返回消息
	 */
	private Object msg;

	/**
	 * @return
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return
	 */
	public Object getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 */
	public void setMsg(Object msg) {
		this.msg = msg;
	}

}
