package com.hcl.matrimonyapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.matrimonyapp.dto.ProfileDto;
import com.hcl.matrimonyapp.dto.ProfileResponseDto;
import com.hcl.matrimonyapp.dto.UserInterestResponseDto;
import com.hcl.matrimonyapp.entity.Profile;
import com.hcl.matrimonyapp.entity.UserInterest;
import com.hcl.matrimonyapp.repository.ProfileRepository;
import com.hcl.matrimonyapp.repository.UserInterestRepository;

@Service
public class UserInterestServiceImpl implements UserInterestService {

	private static Logger logger = Logger.getLogger(UserInterestServiceImpl.class);

	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	UserInterestRepository userInterestRepository;

	public UserInterestResponseDto showInterest(Integer profileId, Integer userInterestProfileId) {
		logger.info("Inside UserServiceImpl method");
		UserInterestResponseDto userInterestResponseDto = new UserInterestResponseDto();
		UserInterest userInterest = new UserInterest();
		Profile profile = new Profile();
		Profile profile1 = new Profile();
		profile = profileRepository.findByProfileId(profileId);
		profile1 = profileRepository.findByProfileId(userInterestProfileId);
		userInterest.setProfileId(profile);
		userInterest.setUserInterestProfileId(profile1);
		userInterestRepository.save(userInterest);
		userInterestResponseDto.setMessage(profile.getFirstName() + " showed interest on " + profile1.getFirstName());
		userInterestResponseDto.setStatusCode(HttpStatus.OK.value());
		return userInterestResponseDto;
	}

	public ProfileResponseDto getInterestedProfiles(Integer profileId) {
		ProfileResponseDto profileResponseDto = new ProfileResponseDto();
		List<ProfileDto> profileDtos = new ArrayList<>();
		Profile profile = profileRepository.findByProfileId(profileId);
		Optional<List<UserInterest>> userInterests = userInterestRepository.findByUserInterestProfileId(profile);
		List<UserInterest> userInterestList = new ArrayList<>();
		if (userInterests.isPresent()) {
			userInterestList = userInterests.get();

			for (UserInterest userInterest : userInterestList) {
				Profile profile1 = userInterest.getProfileId();
				ProfileDto profileDto = new ProfileDto();
				try {
					BeanUtils.copyProperties(profileDto, profile1);
					profileDtos.add(profileDto);

				} catch (Exception exception) {
					logger.info(exception.getMessage());
				}
			}
			profileResponseDto.setMessage("Following profiles showed interest on: " + profile.getUserName());
			profileResponseDto.setStatusCode(HttpStatus.OK.value());
			profileResponseDto.setProfileDto(profileDtos);
			return profileResponseDto;
		} else {
			profileResponseDto.setMessage("Nobody showed interest as of now");
			profileResponseDto.setStatusCode(HttpStatus.OK.value());
			return profileResponseDto;
		}
	}

}
