package com.erdemdis.service;


import com.erdemdis.document.UserProfile;
import com.erdemdis.dto.request.CreateUserRequestDto;
import com.erdemdis.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl {
    private final UserProfileRepository repository;

    public void createUser(CreateUserRequestDto dto) {
        repository.save(UserProfile.builder()
                        .authId(dto.getAuthId())
                        .userName(dto.getUsername())
                        .email(dto.getEmail())
                .build());
    }

    public List<UserProfile> gelAll() {
        return repository.findAll();
    }
}
