package com.springrest.omnifood.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.opencsv.bean.BeanVerifier;
import com.springrest.omnifood.entitiesOrDAO.PaymentEntity;
import jakarta.persistence.Id;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class UserProfileDTO{
    private long id;
    @Pattern(regexp="^[A-za-z]+$",message="name must contain only alphabets")
    @Length(min=2,max=30)
    private String firstName;
    @Pattern(regexp="^[A-za-z]+$",message="name must contain only alphabets")
    @Length(min=2, max=30)
    private String lastName;
    @NotNull
    @Email()
    private String email;
    @NotNull
    @Size(max=13)
    @Pattern(regexp="^+[0-9]{2} [0-9]{10}$",message="invalid phone number")
    private String phone;
    @Pattern(regexp="^M|m|F|f|N|n$",message="please choose a valid gender")
    private String gender;
    private String address;
    private PaymentEntity payment;
    private Validator validator;
    public UserProfileDTO(Validator validator) {
        this.validator=validator;
    }
//    @Override
//    public boolean verifyBean(UserProfileDTO dto) throws Exception{
//        ConstraintViolation<UserProfileDTO> violation =new ConstraintViolationImpl<UserProfileDTO>();
//                validator.validate(dto);
//
//    }




}
