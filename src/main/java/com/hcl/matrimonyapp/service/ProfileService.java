package com.hcl.matrimonyapp.service;

import com.hcl.matrimonyapp.dto.ProfileRequestDto;
import com.hcl.matrimonyapp.dto.ProfileResponseDto;

public interface ProfileService {
	
	public ProfileResponseDto addProfile(ProfileRequestDto profileRequestDto);

}
