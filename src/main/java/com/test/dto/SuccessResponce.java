package com.test.dto;

public class SuccessResponce {
	
	private String massage;
	
	private String msgkey;
	
	private Object data;

	public SuccessResponce(String massage, String msgkey, Object data) {
		super();
		this.massage = massage;
		this.msgkey = msgkey;
		this.data = data;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public String getMsgkey() {
		return msgkey;
	}

	public void setMsgkey(String msgkey) {
		this.msgkey = msgkey;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	

}
