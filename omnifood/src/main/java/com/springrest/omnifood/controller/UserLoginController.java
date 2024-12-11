package com.springrest.omnifood.controller;

import com.springrest.omnifood.dto.LoginDTO;
import com.springrest.omnifood.dto.MessageDTO;
import com.springrest.omnifood.dto.UserProfileDTO;
import com.springrest.omnifood.services.UserLoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class UserLoginController {

    private final UserLoginService userLoginService;
    public UserLoginController(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }
    //create a user
    @PostMapping(path = "/createUser")
    @Operation(summary="create a user of omnifood application",description="returns a single user with their UserProfileDTO",responses={@ApiResponse(responseCode="200",description="user created successfully",content=@Content(mediaType="application/json",schema=@Schema(implementation=UserProfileDTO.class)))})
    public ResponseEntity<MessageDTO> createUser(@Valid @RequestBody UserProfileDTO userProfileDTO) {return new ResponseEntity<>(userLoginService.createUserProfile(userProfileDTO), HttpStatus.OK);}
    //getUser
    @GetMapping(path="{id}/getUser")
    public ResponseEntity<UserProfileDTO> getUser(@PathVariable("id")long id, @PathParam("firstName")String firstName,@PathParam("lastName")String lastName) {return new ResponseEntity<>(userLoginService.getUserProfile(id,firstName,lastName), HttpStatus.OK);}
    //login to the user
    @PostMapping(path="/login")
    public ResponseEntity<MessageDTO> login(@Valid @RequestBody LoginDTO loginDTO) {return new ResponseEntity<>(userLoginService.loginUser(loginDTO),HttpStatus.OK);}
    @GetMapping(path="{client_id}/login/validate")
    public ResponseEntity<MessageDTO> validateLogin(@PathVariable("client_id")long client_id ){
        return validateLogin(client_id);
    }
    //logout of the user
    //edit user profile



}
