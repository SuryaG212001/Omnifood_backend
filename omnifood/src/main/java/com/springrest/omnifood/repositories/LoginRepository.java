package com.springrest.omnifood.repositories;

import com.springrest.omnifood.entitiesOrDAO.LoginEntity;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.springrest.omnifood.constants.AppConstants.HASH_KEY;

@Repository
public class LoginRepository {
    private RedisTemplate redisTemplate;
    public LoginEntity save(LoginEntity loginEntity) {

        redisTemplate.opsForHash().put(HASH_KEY,loginEntity.getId(),loginEntity);
        //domain object is passed as an hash to the template
    return loginEntity;
    }
    public List<LoginEntity> findAll() {
        return redisTemplate.opsForHash().values(HASH_KEY);
    }
    public LoginEntity findById(String client_id) {
        return (LoginEntity) redisTemplate.opsForHash().get(HASH_KEY,client_id);
    }
    public String deleteById(String client_id) {
        redisTemplate.opsForHash().delete(HASH_KEY,client_id);
        return "logged Out";
    }


}
