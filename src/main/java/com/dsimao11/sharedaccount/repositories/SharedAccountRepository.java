package com.dsimao11.sharedaccount.repositories;

import com.dsimao11.sharedaccount.model.entities.SharedAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SharedAccountRepository extends MongoRepository<SharedAccount, String> {

    List<SharedAccount> findByPlatform(String platform);

    List<SharedAccount> findByUsersNickname(String userNickname);

    List<SharedAccount> findByPlatformAndUsersNickname(String platform, String userNickname);
}
