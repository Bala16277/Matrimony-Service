package com.hcl.matrimonyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimonyapp.dto.ProfileResponseDto;
import com.hcl.matrimonyapp.dto.UserInterestResponseDto;
import com.hcl.matrimonyapp.service.UserInterestService;

@RestController
@RequestMapping("/userinterests")
public class UserInterestController {
	
	@Autowired
	UserInterestService userInterestService;
	
	@PostMapping("/")
	public ResponseEntity<UserInterestResponseDto> showInterest(@RequestParam Integer userId, @RequestParam Integer userInterestProfileId) {
		UserInterestResponseDto userInterestResponseDto = new UserInterestResponseDto();
		userInterestResponseDto = userInterestService.showInterest(userId, userInterestProfileId);
		return new ResponseEntity<>(userInterestResponseDto,HttpStatus.CREATED);
	}
	
	@GetMapping("/getInterestedProfiles")
	public ResponseEntity<ProfileResponseDto> getInterestedProfiles(@RequestParam Integer profileId) {
		ProfileResponseDto profileResponseDto = userInterestService.getInterestedProfiles(profileId);
		return new ResponseEntity<>(profileResponseDto,HttpStatus.CREATED);
	}

}
