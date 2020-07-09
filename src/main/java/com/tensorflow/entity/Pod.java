package com.tensorflow.entity;

public class Pod {
	private String nodeName;
	private String podName;
	private String podIP;
	private int isUsing;
	private String podStatus;
	private long endTime;
	
	public Pod() {
		super();
	}
	
	public Pod(String podIP) {
		super();
		this.podIP = podIP;
	}

	public Pod(String podName, String podIP, int isUsing) {
		super();
		this.podName = podName;
		this.podIP = podIP;
		this.isUsing = isUsing;
	}
	
	public Pod(String podName, String podIP, String podStatus) {
		super();
		this.podName = podName;
		this.podIP = podIP;
		this.podStatus = podStatus;
	}

	public Pod(String podIP, String podStatus) {
		super();
		this.podIP = podIP;
		this.podStatus = podStatus;
	}

	public Pod(String nodeName, String podName, String podIP, int isUsing, String podStatus, long endTime) {
		super();
		this.nodeName = nodeName;
		this.podName = podName;
		this.podIP = podIP;
		this.isUsing = isUsing;
		this.podStatus = podStatus;
		this.endTime = endTime;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public String getPodName() {
		return podName;
	}
	public void setPodName(String podName) {
		this.podName = podName;
	}
	public String getPodIP() {
		return podIP;
	}
	public void setPodIP(String podIP) {
		this.podIP = podIP;
	}
	public int getIsUsing() {
		return isUsing;
	}
	public void setIsUsing(int isUsing) {
		this.isUsing = isUsing;
	}
	
	public String getPodStatus() {
		return podStatus;
	}
	
	public void setPodStatus(String podStatus) {
		this.podStatus = podStatus;
	}
	
	@Override
	public String toString() {
		return "Pod [nodeName=" + nodeName + ", podName=" + podName + ", podIP=" + podIP + ", isUsing=" + isUsing
				+ ", podStatus=" + podStatus + ", endTime=" + endTime + "]";
	}
	
	
}
