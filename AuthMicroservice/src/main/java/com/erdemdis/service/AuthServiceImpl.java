package com.erdemdis.service;

import com.erdemdis.dto.request.CreateUserRequestDto;
import com.erdemdis.dto.request.LoginReponseDto;
import com.erdemdis.dto.request.RegisterRequestDto;
import com.erdemdis.entity.Auth;
import com.erdemdis.manager.UserProfileManager;
import com.erdemdis.repository.AuthRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl {
    private final AuthRepository repository;
    private final UserProfileManager userProfileManager;


    @Transactional
    public Auth register(RegisterRequestDto dto) {

        try {
            Auth auth= repository.save(Auth.builder()
                    .userName(dto.getUserName())
                    .email(dto.getEmail())
                    .password(dto.getPassword())
                    .build());
            userProfileManager.createUser(CreateUserRequestDto.builder()
                    .authId(auth.getId())
                    .username(auth.getUserName())
                    .email(auth.getEmail())
                    .build());
            return auth;
        }catch (Exception e){
            throw new RuntimeException("Tekrar Deneyiniz.",e);
        }

    }

    public  Boolean login(LoginReponseDto dto) {
        return repository.existsByUserNameAndPassword(dto.getUserName(),dto.getPassword());
    }
}
