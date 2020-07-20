package com.hcl.matrimonyapp.service;

import com.hcl.matrimonyapp.dto.ProfileResponseDto;
import com.hcl.matrimonyapp.dto.UserInterestResponseDto;

public interface UserInterestService {
	
	public UserInterestResponseDto showInterest(Integer profileId, Integer userInterestProfileId);

	public ProfileResponseDto getInterestedProfiles(Integer profileId);
	
}
