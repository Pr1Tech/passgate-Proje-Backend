package com.project.passwordpolicy.repos;

import com.project.passwordpolicy.entities.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
