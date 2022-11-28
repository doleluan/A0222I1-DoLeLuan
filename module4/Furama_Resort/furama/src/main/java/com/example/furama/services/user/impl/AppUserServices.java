package com.example.furama.services.user.impl;

import com.example.furama.model.user.AppUser;
import com.example.furama.repository.user.UserRepository;
import com.example.furama.services.user.IAppUserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServices implements IAppUserServices {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(AppUser appUser) {
        userRepository.save(appUser);
    }
}
