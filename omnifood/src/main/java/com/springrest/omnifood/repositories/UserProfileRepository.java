package com.springrest.omnifood.repositories;


import com.springrest.omnifood.dto.UserProfileDTO;
import com.springrest.omnifood.entitiesOrDAO.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfileEntity,Long> {

    UserProfileEntity getReferenceById(long id);
    UserProfileEntity saveAndFlush(UserProfileEntity user);
}
