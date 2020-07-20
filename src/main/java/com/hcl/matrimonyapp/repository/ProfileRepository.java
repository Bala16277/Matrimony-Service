package com.hcl.matrimonyapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.matrimonyapp.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

	public Optional<Profile> findByUserName(String userName);
	
	public Profile findByProfileId(Integer profileId);
	
	
	
}
