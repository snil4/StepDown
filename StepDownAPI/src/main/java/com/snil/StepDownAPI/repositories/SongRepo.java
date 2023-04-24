package com.snil.StepDownAPI.repositories;

import com.snil.StepDownAPI.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepo extends JpaRepository<Song, Long> {
}
