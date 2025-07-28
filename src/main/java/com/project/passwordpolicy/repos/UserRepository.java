package com.project.passwordpolicy.repos;

import com.project.passwordpolicy.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
