package com.erdemdis.controller;


import com.erdemdis.dto.request.LoginReponseDto;
import com.erdemdis.dto.request.RegisterRequestDto;
import com.erdemdis.entity.Auth;
import com.erdemdis.service.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.erdemdis.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTHSERVICE)
public class AuthController {
    private final AuthServiceImpl authService;

    @PostMapping(REGISTER)
    public ResponseEntity<Auth> register(@RequestBody RegisterRequestDto dto){
        if(!dto.getPassword().equals(dto.getRePassword()))
            throw new RuntimeException("Sifreler uyumsuz");

        return ResponseEntity.ok(authService.register(dto));

    }

    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody LoginReponseDto dto){
        return ResponseEntity.ok(authService.login(dto));

    }
}
