package com.jacr.server.application.service;

import com.jacr.server.application.ports.input.ProfileServicePort;
import com.jacr.server.application.dto.ProfileDTO;
import com.jacr.server.application.ports.output.ProfilePersistencePort;
import com.jacr.server.domain.model.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileService implements ProfileServicePort {

    private  final ProfilePersistencePort profilePersistencePort;

    @Override
    public ProfileDTO registerProfile(ProfileDTO profileDTO) {
        Profile newProfile = toModel(profileDTO);
        newProfile.setActivationToken(UUID.randomUUID().toString());
        newProfile = profilePersistencePort.save(newProfile);


        return toProfileDTO(newProfile);
    }

    public Profile toModel(ProfileDTO profileDTO){
        Profile profile = new Profile();

        profile.setId(profileDTO.getId());
        profile.setFullName(profileDTO.getFullName());
        profile.setEmail(profileDTO.getEmail());
        profile.setPassword(profileDTO.getPassword());
        profile.setProfileImageUrl(profileDTO.getProfileImageUrl());
        profile.setCreatedAt(profileDTO.getCreatedAt());
        profile.setUpdatedAt(profileDTO.getUpdatedAt());

        return profile;
    }

    public ProfileDTO toProfileDTO(Profile profile){
        return ProfileDTO.builder()
                .id(profile.getId())
                .fullName(profile.getFullName())
                .email(profile.getEmail())
                .profileImageUrl(profile.getProfileImageUrl())
                .createdAt(profile.getCreatedAt())
                .updatedAt(profile.getUpdatedAt())
                .build();

    }
}
