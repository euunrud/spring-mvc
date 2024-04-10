package com.example.helloworld.domain;

public class PerformReq {
	private String performerId;
	private String requesterName;

	public String getPerformerId() {
		return performerId;
	}

	public String getRequesterName() {
		return requesterName;
	}

	public void setPerformerId(String performerId) {
		this.performerId = performerId;
	}

	public void setRequesterName(String requesterName) {
		this.requesterName = requesterName;
	}
}
