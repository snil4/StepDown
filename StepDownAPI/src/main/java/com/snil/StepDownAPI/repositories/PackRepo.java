package com.snil.StepDownAPI.repositories;

import com.snil.StepDownAPI.entities.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackRepo extends JpaRepository<Pack, Long> {
}
