package com.jacr.server.infrastructure.input.controller;

import com.jacr.server.application.dto.ProfileDTO;
import com.jacr.server.application.ports.input.ProfileServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class ProfileController {
    private final ProfileServicePort profileServicePort;

    @PostMapping("/register")
    public ResponseEntity<ProfileDTO> registerProfile(@RequestBody ProfileDTO profileDTO){
        return new  ResponseEntity<>(profileServicePort.registerProfile(profileDTO), HttpStatus.CREATED);
    }
}
