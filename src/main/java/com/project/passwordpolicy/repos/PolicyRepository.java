package com.project.passwordpolicy.repos;

import com.project.passwordpolicy.entities.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
}
