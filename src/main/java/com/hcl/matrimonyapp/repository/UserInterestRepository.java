package com.hcl.matrimonyapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.matrimonyapp.entity.Profile;
import com.hcl.matrimonyapp.entity.UserInterest;

@Repository
public interface UserInterestRepository extends JpaRepository<UserInterest, Integer> {
	
	public Optional<List<UserInterest>> findByUserInterestProfileId(Profile profile);
	

}
