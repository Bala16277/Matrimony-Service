package com.hcl.matrimonyapp.service;

import java.util.Optional;

import org.apache.commons.beanutils.BeanUtils;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.matrimonyapp.dto.ProfileRequestDto;
import com.hcl.matrimonyapp.dto.ProfileResponseDto;
import com.hcl.matrimonyapp.entity.Preference;
import com.hcl.matrimonyapp.entity.Profile;
import com.hcl.matrimonyapp.repository.PreferenceRepository;
import com.hcl.matrimonyapp.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	private static Logger logger = Logger.getLogger(ProfileServiceImpl.class);

	@Autowired
	ProfileRepository profileRepository;
	
	@Autowired
	PreferenceRepository preferenceRepository;

	public ProfileResponseDto addProfile(ProfileRequestDto profileRequestDto) {

		ProfileResponseDto profileResponseDto = new ProfileResponseDto();
		Profile profile = new Profile();
		Optional<Profile> profiles = profileRepository.findByUserName(profileRequestDto.getUserName());
		if (profiles.isPresent()) {
			profileResponseDto.setMessage("Profile already exists");
			profileResponseDto.setStatusCode(HttpStatus.OK.value());
			return profileResponseDto;
		}
		try {
			BeanUtils.copyProperties(profile, profileRequestDto);
			profileRepository.save(profile);
			Preference preference = new Preference();
			BeanUtils.copyProperties(preference, profileRequestDto);
			preference.setProfile(profile);
			preferenceRepository.save(preference);
			profileResponseDto.setMessage("Profile saved successfully");
			profileResponseDto.setStatusCode(HttpStatus.CREATED.value());

		} catch (Exception exception) {
			logger.info(exception.getMessage());
		}

		return profileResponseDto;

	}

}
