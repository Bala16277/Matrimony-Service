package com.hcl.matrimonyapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserInterest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userInterestId;

	@OneToOne
	@JoinColumn(name = "profileId")
	private Profile profileId;

	@OneToOne
	@JoinColumn(name = "userId")
	private Profile userInterestProfileId;

	public Integer getUserInterestId() {
		return userInterestId;
	}

	public void setUserInterestId(Integer userInterestId) {
		this.userInterestId = userInterestId;
	}

	public Profile getProfileId() {
		return profileId;
	}

	public void setProfileId(Profile profileId) {
		this.profileId = profileId;
	}

	public Profile getUserInterestProfileId() {
		return userInterestProfileId;
	}

	public void setUserInterestProfileId(Profile userInterestProfileId) {
		this.userInterestProfileId = userInterestProfileId;
	}

}
