package com.snil.StepDownAPI.services;

import com.snil.StepDownAPI.entities.Song;
import com.snil.StepDownAPI.repositories.PackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PackService {

    @Autowired
    private PackRepo packRepo;
}
