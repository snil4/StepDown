package com.snil.StepDownAPI.repositories;

import com.snil.StepDownAPI.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
