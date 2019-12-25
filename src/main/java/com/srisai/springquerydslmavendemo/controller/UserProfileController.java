package com.srisai.springquerydslmavendemo.controller;

import com.srisai.springquerydslmavendemo.model.UserProfile;
import com.srisai.springquerydslmavendemo.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@RestController
@RequestMapping("/users")
@Validated
@Component
public class UserProfileController {
    private static final String REGEX_PATTERN = "^[a-zA-z0-9]+$";

    @Autowired
    public UserProfileService userProfileService;

    @GetMapping("/all")
    public List<UserProfile> getAllUsers() {
        return userProfileService.getAllUsers();
    }

    @GetMapping("/{name}")
//    public HttpEntity<List<UserProfile>> getUsersByName(@Size(min = 3, message = "Shouldn't be less than 3 Characters")
//                                            @Pattern( regexp = REGEX_PATTERN, message = "Input should be alphanumerics")
//                                            @PathVariable("name") String name) {

    public HttpEntity<List<UserProfile>> getUsersByName(@PathVariable("name") String name) {
        return new ResponseEntity<>( userProfileService.getUsersByName(name), HttpStatus.OK);

    }
}
