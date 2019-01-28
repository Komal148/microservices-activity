package com.stackroute.repository;

import com.stackroute.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends MongoRepository<User,Integer> {

    //this is used to select trackByName
    // @Query(value = "Select m from Music m  where m.trackName = ?1")
//    public List<Music> findByTrackName(String trackName);
}
