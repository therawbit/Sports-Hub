package io.github.sudru.SportsHub.repository;

import io.github.sudru.SportsHub.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,ObjectId> {
    Optional<User> findByEmail(String username);
}
