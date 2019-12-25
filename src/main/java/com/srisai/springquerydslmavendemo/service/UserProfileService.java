package com.srisai.springquerydslmavendemo.service;

import com.srisai.springquerydslmavendemo.model.UserProfile;

import java.util.List;

public interface UserProfileService {

    public List<UserProfile> getAllUsers();

    public List<UserProfile> getUsersByName(String name);
}
