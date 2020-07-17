package com.hcl.matrimonyapp.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class UserInterest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userInterestId;

	@OneToOne
	@JoinColumn(name = "userId")
	private Profile userId;

	@OneToOne
	@JoinColumn(name = "userId")
	private Profile userInterestProfileId;

	public Integer getUserInterestId() {
		return userInterestId;
	}

	public void setUserInterestId(Integer userInterestId) {
		this.userInterestId = userInterestId;
	}

	public Profile getUserId() {
		return userId;
	}

	public void setUserId(Profile userId) {
		this.userId = userId;
	}

	public Profile getUserInterestProfileId() {
		return userInterestProfileId;
	}

	public void setUserInterestProfileId(Profile userInterestProfileId) {
		this.userInterestProfileId = userInterestProfileId;
	}


}
