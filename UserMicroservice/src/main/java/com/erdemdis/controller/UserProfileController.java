package com.erdemdis.controller;


import com.erdemdis.document.UserProfile;
import com.erdemdis.dto.request.CreateUserRequestDto;
import com.erdemdis.service.UserProfileServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.erdemdis.config.RestApis.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(USERPROFILE)
public class UserProfileController {
    private final UserProfileServiceImpl userProfileService;

    @PostMapping(CREATE_USER)
    public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto dto){
        userProfileService.createUser(dto);
        return ResponseEntity.ok(true);

    }

    @PostMapping(GET_ALL)
    public ResponseEntity<List<UserProfile>> getAll(){
        return ResponseEntity.ok( userProfileService.gelAll());

    }
}
