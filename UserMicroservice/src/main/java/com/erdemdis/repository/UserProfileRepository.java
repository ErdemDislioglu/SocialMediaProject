package com.erdemdis.repository;

import com.erdemdis.document.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserProfileRepository extends MongoRepository<UserProfile,String> {
}
