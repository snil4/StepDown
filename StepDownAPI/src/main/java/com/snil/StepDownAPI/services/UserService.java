package com.snil.StepDownAPI.services;

import com.snil.StepDownAPI.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;
}
