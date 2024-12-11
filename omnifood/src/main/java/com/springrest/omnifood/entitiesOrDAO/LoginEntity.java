package com.springrest.omnifood.entitiesOrDAO;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

@Entity
@RedisHash("userProfile")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_login_entity")
public class LoginEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
    generator="seq_login_id")
    @SequenceGenerator(name="seq_login_id",sequenceName="tbl_audit_requests",allocationSize = 1)
    private Long id;
    @Column(name="client_id",unique=true)
    private String clientId;
    @Column(name="client_secret",unique=true)
    private String clientSecret;
    @Column(name="remember_me")
    private boolean rememberMe;

}
