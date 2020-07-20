package com.hcl.matrimonyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.matrimonyapp.entity.Preference;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, Integer> {

}