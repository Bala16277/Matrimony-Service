package com.hcl.matrimonyapp.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimonyapp.dto.DefaultProfileDto;
import com.hcl.matrimonyapp.entity.Preference;
import com.hcl.matrimonyapp.entity.Profile;
import com.hcl.matrimonyapp.repository.PreferenceRepository;
import com.hcl.matrimonyapp.repository.ProfileRepository;

@Service
public class SearchProfileService {

	@Autowired
	ProfileRepository profileRepository;
	@Autowired
	PreferenceRepository preferenceRepository;
	@PersistenceContext
	EntityManager entityManager;

	/**
	 * @param profileId
	 * @return
	 */
	public List<DefaultProfileDto> getDefaultProfile(int profileId) {

		List<DefaultProfileDto> DefaultProfileDtos = new ArrayList();

		// Preference preference = new Preference();

		Profile profile = profileRepository.findByprofileId(profileId);

		Preference preferences = preferenceRepository.findByProfileId(profile);

		List<Profile> profiles = profileRepository.findAllByLocation(preferences.getPreferenceLocation());
		if (profiles != null) {
			for (Profile profil : profiles) {
				DefaultProfileDto DefaultProfileDto = new DefaultProfileDto();
				BeanUtils.copyProperties(profil, DefaultProfileDto);
				DefaultProfileDtos.add(DefaultProfileDto);
			}
		}

		return DefaultProfileDtos;

	}

	/**
	 * @param defaultReqProfileDto
	 * @return
	 */
	public List<DefaultProfileDto> getProfile(DefaultProfileDto defaultReqProfileDto) {

		StringBuilder selectQuery = buildQuery(defaultReqProfileDto);

		if(selectQuery.substring(29, 32).equalsIgnoreCase("and")) {
			selectQuery.delete(29, 32); 
			System.out.println(selectQuery.toString());
		}
		Query query = entityManager.createNativeQuery(selectQuery.toString());
		return query.getResultList();
	}

	/**
	 * @param defaultReqProfileDto
	 * @return
	 */
	private StringBuilder buildQuery(DefaultProfileDto defaultReqProfileDto) {
		StringBuilder selectQuerybuilder = new StringBuilder("select * from profile where ");
		if (!defaultReqProfileDto.getLocation().equals("") && defaultReqProfileDto.getLocation() != null) {
			selectQuerybuilder.append("location = " + '\'' + defaultReqProfileDto.getLocation() + '\'');
		}
		if (!defaultReqProfileDto.getReligion().equals("") && defaultReqProfileDto.getReligion() != null) {
			selectQuerybuilder.append(" and  religion = " + '\'' + defaultReqProfileDto.getReligion() + '\'');
		}
		if (!defaultReqProfileDto.getUserName().equals("") && defaultReqProfileDto.getUserName() != null) {
			selectQuerybuilder.append(" and user_name = " + '\'' + defaultReqProfileDto.getUserName() + '\'');
		}
		if (!defaultReqProfileDto.getEmail().equals("") && defaultReqProfileDto.getEmail() != null) {
			selectQuerybuilder.append(" and email = " + '\'' + defaultReqProfileDto.getEmail() + '\'');
		}
		if (!defaultReqProfileDto.getPhoneNumber().equals("") && defaultReqProfileDto.getPhoneNumber() != null) {
			selectQuerybuilder.append(" and phone_numbar = " + '\'' + defaultReqProfileDto.getPhoneNumber() + '\'');
		}
		if (!defaultReqProfileDto.getFirstName().equals("") && defaultReqProfileDto.getFirstName() != null) {
			selectQuerybuilder.append(" and first_name = " + '\'' + defaultReqProfileDto.getFirstName() + '\'');
		}
		if (!defaultReqProfileDto.getLastName().equals("") && defaultReqProfileDto.getLastName() != null) {
			selectQuerybuilder.append(" and last_name = " + '\'' + defaultReqProfileDto.getLastName() + '\'');
		}
		if (!defaultReqProfileDto.getGender().equals("") && defaultReqProfileDto.getGender() != null) {
			selectQuerybuilder.append(" and gender = " + '\'' + defaultReqProfileDto.getGender() + '\'');
		}
		if (defaultReqProfileDto.getAge() != null) {
			selectQuerybuilder.append(" and age = " + '\'' + defaultReqProfileDto.getAge() + '\'');
		}
		if (!defaultReqProfileDto.getMotherTongue().equals("") && defaultReqProfileDto.getMotherTongue() != null) {
			selectQuerybuilder.append(" and mother_tongue = " + '\'' + defaultReqProfileDto.getMotherTongue() + '\'');
		}
		// return selectQuerybuilder.toString();
		return selectQuerybuilder;
	}

}
