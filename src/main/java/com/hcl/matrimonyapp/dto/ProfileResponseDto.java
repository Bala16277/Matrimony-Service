package com.hcl.matrimonyapp.dto;

import java.util.List;

public class ProfileResponseDto {
	

	private String message;

	private Integer statusCode;
	
	private List<ProfileDto> profileDto;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public List<ProfileDto> getProfileDto() {
		return profileDto;
	}

	public void setProfileDto(List<ProfileDto> profileDto) {
		this.profileDto = profileDto;
	}
	
	
	
	

}
