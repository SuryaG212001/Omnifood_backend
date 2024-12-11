package com.springrest.omnifood.serviceImpl;

import com.springrest.omnifood.dto.LoginDTO;
import com.springrest.omnifood.dto.UserProfileDTO;
import com.springrest.omnifood.entitiesOrDAO.LoginEntity;
import com.springrest.omnifood.entitiesOrDAO.UserProfileEntity;
import com.springrest.omnifood.repositories.LoginRepository;
import com.springrest.omnifood.repositories.UserProfileRepository;
import com.springrest.omnifood.services.UserLoginService;
import com.springrest.omnifood.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    final UserProfileRepository userProfileRepository;
    final LoginRepository loginRepository;
    public UserLoginServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
        this.loginRepository = new LoginRepository();
        //the @Service annotation sees the repository declared as a final object and finds the object to be used as a bean for it and autoconfigures the bean for the same
    }


    public UserProfileDTO getUserProfile(long id, String firstName, String lastName){
        UserProfileEntity user= userProfileRepository.getReferenceById(id);
        return UserProfileDTO.builder().id(user.getId()).email(user.getEmail()).firstName(firstName).lastName(lastName).build();


    }
    public MessageDTO createUserProfile(UserProfileDTO userProfileDTO){
        UserProfileEntity user=new UserProfileEntity();
        user.setId(userProfileDTO.getId());
        user.setEmail(userProfileDTO.getEmail());
        user.setFirstName(userProfileDTO.getFirstName());
        user.setLastName(userProfileDTO.getLastName());//confused
         UserProfileEntity savedUser=userProfileRepository.saveAndFlush(user);
         if(savedUser!=null){return MessageDTO.builder().type("User created").message("user created successfully").build();}
        else{
            return MessageDTO.builder().type("User already exists").message("user already exists").build();
         }

    }
    public MessageDTO loginUser(LoginDTO loginDTO){
        LoginEntity loginUser=new LoginEntity();
        loginUser.setId(loginDTO.getId());
        loginUser.setClientId(loginDTO.getClientId());
        loginUser.setClientSecret(loginDTO.getClientSecret());
        loginUser.setRememberMe(loginDTO.isRememberMe());
        loginRepository.save(loginUser);
        return MessageDTO.builder().type("logged in").message("loggedIn successfully").build();


    }
    public MessageDTO validateLogin(String client_id){
        LoginEntity loginUser=loginRepository.findById(client_id);
        if(loginUser==null){
            return MessageDTO.builder().type("User Not Found").message("no user found with the given credentials").build();
        }
        if(loginUser.isRememberMe()){
            return MessageDTO.builder().type("logged in").message("successfully logged in").build();
        }
        else{
            return MessageDTO.builder().type("logged out").message("successfully logged out").build();
        }
    }

}
