package com.cause.Repos;

import com.cause.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    public User findUserByEmail(String email);
    public User findUserBy_id(String userId);

}
