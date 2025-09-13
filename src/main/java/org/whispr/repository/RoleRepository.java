package org.whispr.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.whispr.entity.Role;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
        Optional<Role> findByRole(Role.ERole role);
}
