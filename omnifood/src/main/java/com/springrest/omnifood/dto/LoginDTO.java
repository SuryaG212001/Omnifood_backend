package com.springrest.omnifood.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO implements Serializable {
    private Long id;
    private String clientId;
    private String clientSecret;
    private Timestamp timestamp;
    private boolean rememberMe;
}
