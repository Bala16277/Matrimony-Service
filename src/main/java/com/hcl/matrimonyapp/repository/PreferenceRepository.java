package com.hcl.matrimonyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.hcl.matrimonyapp.entity.Preference;
import com.hcl.matrimonyapp.entity.Profile;


public interface PreferenceRepository extends JpaRepository<Preference, Integer>{

	Preference findByProfileId(Profile profile);

}
