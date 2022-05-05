package com.cause.Repos;


import com.cause.Entities.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface QuesRepository extends MongoRepository<Question, String> {
    public Question findBy_id(String id);

}
