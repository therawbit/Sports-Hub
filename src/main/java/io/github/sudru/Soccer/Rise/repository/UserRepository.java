package io.github.sudru.Soccer.Rise.repository;

import io.github.sudru.Soccer.Rise.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,ObjectId> {
    Optional<User> findByEmail(String username);
}
