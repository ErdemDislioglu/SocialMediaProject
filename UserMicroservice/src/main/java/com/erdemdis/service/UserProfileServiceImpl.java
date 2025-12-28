package com.erdemdis.service;


import com.erdemdis.document.UserProfile;
import com.erdemdis.dto.request.CreateUserRequestDto;
import com.erdemdis.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl {
    private final UserProfileRepository repository;
    private final CacheManager cacheManager;

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

    @Cacheable("upperName")
    public  String upperName(String name) {
        String result=name.toUpperCase();
        try{
            Thread.sleep(3000L);
        }catch (Exception e){}
        return result;
    }

    public void clearCache(){
        cacheManager.getCache("upperName").clear();
    }

}
