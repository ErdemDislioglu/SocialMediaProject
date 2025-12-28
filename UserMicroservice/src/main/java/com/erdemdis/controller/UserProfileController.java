package com.erdemdis.controller;


import com.erdemdis.document.UserProfile;
import com.erdemdis.dto.request.CreateUserRequestDto;
import com.erdemdis.service.UserProfileServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(GET_ALL)
    public ResponseEntity<List<UserProfile>> getAll(){
        return ResponseEntity.ok( userProfileService.gelAll());

    }

    @GetMapping(UPPER_NAME)
    public ResponseEntity<String> upperName(String name){
        return ResponseEntity.ok(userProfileService.upperName(name));

    }
}
