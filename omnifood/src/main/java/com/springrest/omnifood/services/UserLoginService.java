package com.springrest.omnifood.services;

import com.springrest.omnifood.dto.LoginDTO;
import com.springrest.omnifood.dto.MessageDTO;
import com.springrest.omnifood.dto.UserProfileDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface UserLoginService {

    public UserProfileDTO getUserProfile(long id, String firstName, String lastName);
    public MessageDTO createUserProfile(UserProfileDTO userProfileDTO);
    public MessageDTO loginUser(LoginDTO loginDTO);

}
