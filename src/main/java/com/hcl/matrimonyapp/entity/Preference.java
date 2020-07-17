package com.hcl.matrimonyapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Preference {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer preferenceId;

	private Integer preferenceAge;

	private String preferenceGender;

	private String preferenceLocation;

	private String preferenceReligion;

	private String preferenceMotherTongue;
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;

	public Integer getPreferenceId() {
		return preferenceId;
	}

	public void setPreferenceId(Integer preferenceId) {
		this.preferenceId = preferenceId;
	}

	public Integer getPreferenceAge() {
		return preferenceAge;
	}

	public void setPreferenceAge(Integer preferenceAge) {
		this.preferenceAge = preferenceAge;
	}

	public String getPreferenceGender() {
		return preferenceGender;
	}

	public void setPreferenceGender(String preferenceGender) {
		this.preferenceGender = preferenceGender;
	}

	public String getPreferenceLocation() {
		return preferenceLocation;
	}

	public void setPreferenceLocation(String preferenceLocation) {
		this.preferenceLocation = preferenceLocation;
	}

	public String getPreferenceReligion() {
		return preferenceReligion;
	}

	public void setPreferenceReligion(String preferenceReligion) {
		this.preferenceReligion = preferenceReligion;
	}

	public String getPreferenceMotherTongue() {
		return preferenceMotherTongue;
	}

	public void setPreferenceMotherTongue(String preferenceMotherTongue) {
		this.preferenceMotherTongue = preferenceMotherTongue;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
