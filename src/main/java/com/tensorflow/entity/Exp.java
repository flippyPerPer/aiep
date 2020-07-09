package com.tensorflow.entity;

public class Exp {
	private String expName;
	private String expInfo;
	private String expType;
	private String tchNum;
	private String expApi; 
	private String expEnvirment;
	private String expPodName;
	private String expURLPic; 
	private String expID;
	private int expTimes = 0;

	public Exp() {
	}

	public Exp(String expName, String expInfo, String tchNum) {
		super();
		this.expName = expName;
		this.expInfo = expInfo;
		this.tchNum = tchNum;
	}

	public Exp(String expID, String expName, String expInfo, int expTimes) {
		super();
		this.expName = expName;
		this.expInfo = expInfo;
		this.expID = expID;
		this.expTimes = expTimes;
	}
	
	public Exp( String expID,String expName, String expInfo, int expTimes, String expURLPic) {
		super();
		this.expName = expName;
		this.expInfo = expInfo;
		this.expURLPic = expURLPic;
		this.expID = expID;
		this.expTimes = expTimes;
	}

	public Exp(String expName, String expInfo, String expType, String tchNum, String expApi, String expURLPic) {
		super();
		this.expName = expName;
		this.expInfo = expInfo;
		this.expType = expType;
		this.tchNum = tchNum;
		this.expApi = expApi;
		this.expURLPic = expURLPic;
	}

	public Exp(String expID,String expName, String expInfo, String expType, String tchNum, String expApi, String expEnvirment,
			String expURLPic, int expTimes) {
		super();
		this.expName = expName;
		this.expInfo = expInfo;
		this.expType = expType;
		this.tchNum = tchNum;
		this.expApi = expApi;
		this.expEnvirment = expEnvirment;
		this.expURLPic = expURLPic;
		this.expID = expID;
		this.expTimes = expTimes;
	}

	public String getExpPodName() {
		return expPodName;
	}

	public void setExpPodName(String expPodName) {
		this.expPodName = expPodName;
	}

	public String getExpName() {
		return expName;
	}

	public void setExpName(String expName) {
		this.expName = expName;
	}

	public String getExpInfo() {
		return expInfo;
	}

	public void setExpInfo(String expInfo) {
		this.expInfo = expInfo;
	}

	public String getExpType() {
		return expType;
	}

	public void setExpType(String expType) {
		this.expType = expType;
	}

	public String getTchNum() {
		return tchNum;
	}

	public void setTchNum(String tchNum) {
		this.tchNum = tchNum;
	}

	public String getExpApi() {
		return expApi;
	}

	public void setExpApi(String expApi) {
		this.expApi = expApi;
	}

	public String getExpEnvirment() {
		return expEnvirment;
	}

	public void setExpEnvirment(String expEnvirment) {
		this.expEnvirment = expEnvirment;
	}

	public String getExpURLPic() {
		return expURLPic;
	}

	public void setExpURLPic(String expURLPic) {
		this.expURLPic = expURLPic;
	}

	public String getExpID() {
		return expID;
	}

	public int getExpTimes() {
		return expTimes;
	}

	public void setExpTimes(int expTimes) {
		this.expTimes = expTimes;
	}

	public void setExpID(String expID) {
		this.expID = expID;
	}

	@Override
	public String toString() {
		return "Exp [expName=" + expName + ", expInfo=" + expInfo + ", expType=" + expType + ", tchNum=" + tchNum + "]";
	}

}
