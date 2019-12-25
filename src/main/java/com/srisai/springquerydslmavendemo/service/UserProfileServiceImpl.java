package com.srisai.springquerydslmavendemo.service;

import com.querydsl.jpa.impl.JPAQuery;
import com.srisai.springquerydslmavendemo.model.QUserProfile;
import com.srisai.springquerydslmavendemo.model.UserProfile;
import com.srisai.springquerydslmavendemo.repo.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    public UserProfileRepository userProfileRepository;

    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public List<UserProfile> getAllUsers() {
        return userProfileRepository.findAll();
    }

    @Override
    public List<UserProfile> getUsersByName(String name) {
        QUserProfile qUserProfile = QUserProfile.userProfile;

        JPAQuery<UserProfile> query = new JPAQuery(entityManager);

        return query.from(qUserProfile).where(qUserProfile.firstName.startsWith( name )
                                        .or(qUserProfile.lastName.startsWith( name ))
                                        .or(qUserProfile.userId.startsWith( name ))
                                        .or(qUserProfile.firstName.contains( name )
                                        .or(qUserProfile.lastName.contains( name ))
                                        .or(qUserProfile.userId.contains( name )))).distinct().fetch();

    }
}
