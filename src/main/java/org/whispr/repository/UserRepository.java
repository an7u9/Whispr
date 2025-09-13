package org.whispr.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.whispr.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    List<User> findByUsernameContainingIgnoreCase(String keyword);

    // Find online users
    List<User> findByStatusOrderByLastActiveAtDesc(String status);
}
