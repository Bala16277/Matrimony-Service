package com.hcl.matrimonyapp.repository;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.matrimonyapp.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer>{

	//Profile findByprofileId(int profileId);
	Profile findByprofileId(Integer profileId);
	public Optional<Profile> findByUserName(String userName);

	List<Profile> findAllByLocation(String preferenceLocation);
	Profile findByProfileId(Integer profileId);


}


//@Repository
//public interface ProfileRepository extends JpaRepository<Profile, Integer> {
//
//	
//	
//	//public Profile findByProfileId(Integer profileId);
//	
//	
//	
//
//}
