package com.dsimao11.sharedaccount.repositories;

import com.dsimao11.sharedaccount.model.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByNickname(String nickname);
}
