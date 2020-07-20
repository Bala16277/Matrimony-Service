package com.hcl.matrimonyapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.matrimonyapp.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer>{

	Profile findByprofileId(int profileId);

	List<Profile> findAllByLocation(String preferenceLocation);

}
