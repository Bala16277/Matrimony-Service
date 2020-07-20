package com.hcl.matrimonyapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimonyapp.dto.DefaultProfileDto;
import com.hcl.matrimonyapp.service.SearchProfileService;


@RestController
@RequestMapping("/profile")
public class SearchProfileController {

	@Autowired SearchProfileService searchProfileService;
	
	@GetMapping("")
	public ResponseEntity<List<DefaultProfileDto>> getDefaultProfile(@RequestParam int profileId){
		List<DefaultProfileDto> defaultProfileDto = searchProfileService.getDefaultProfile(profileId);
	
		return new ResponseEntity<>(defaultProfileDto, HttpStatus.OK);
	}
	
	@PostMapping("/search")
	public ResponseEntity<List<DefaultProfileDto>> getProfile(@RequestBody DefaultProfileDto defaultReqProfileDto){
		List<DefaultProfileDto> defaultProfileDto = searchProfileService.getProfile(defaultReqProfileDto);
	
		return new ResponseEntity<>(defaultProfileDto, HttpStatus.OK);
	}
}
