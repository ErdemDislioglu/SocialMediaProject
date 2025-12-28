package com.erdemdis.service;

import com.erdemdis.dto.request.LoginReponseDto;
import com.erdemdis.dto.request.RegisterRequestDto;
import com.erdemdis.entity.Auth;
import com.erdemdis.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl {
    private final AuthRepository repository;


    public Auth register(RegisterRequestDto dto) {

        return repository.save(Auth.builder()
                        .userName(dto.getUserName())
                        .email(dto.getEmail())
                        .password(dto.getPassword())
                .build());
    }

    public  Boolean login(LoginReponseDto dto) {
        return repository.existsByUserNameAndPassword(dto.getUserName(),dto.getPassword());
    }
}
