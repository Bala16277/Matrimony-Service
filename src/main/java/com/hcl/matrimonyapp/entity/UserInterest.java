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
	private User userId;

	@OneToOne
	@JoinColumn(name = "userId")
	private User interestId;

	public Integer getUserInterestId() {
		return userInterestId;
	}

	public void setUserInterestId(Integer userInterestId) {
		this.userInterestId = userInterestId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public User getInterestId() {
		return interestId;
	}

	public void setInterestId(User interestId) {
		this.interestId = interestId;
	}

}
