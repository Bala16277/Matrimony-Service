package com.hcl.matrimonyapp.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimonyapp.dto.ProfileRequestDto;
import com.hcl.matrimonyapp.dto.ProfileResponseDto;
import com.hcl.matrimonyapp.service.ProfileService;

@RestController
@RequestMapping("/profiles")
public class ProfileController {
	
	private static Logger logger = Logger.getLogger(ProfileController.class);
	
	@Autowired
	ProfileService profileService;
	
	@PostMapping("/")
	public ResponseEntity<ProfileResponseDto> addProfiles(@RequestBody ProfileRequestDto profileRequestDto) {
		ProfileResponseDto profileResponseDto = new ProfileResponseDto();
		logger.info("Inside add profile method of controller");
		profileResponseDto = profileService.addProfile(profileRequestDto);
		return new ResponseEntity<>(profileResponseDto,HttpStatus.CREATED);
	}
	
	

}
