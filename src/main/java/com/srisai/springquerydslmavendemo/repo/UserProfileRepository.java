package com.srisai.springquerydslmavendemo.repo;

import com.srisai.springquerydslmavendemo.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer>, QuerydslPredicateExecutor<UserProfile> {

}
