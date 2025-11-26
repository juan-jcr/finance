package com.jacr.server.infrastructure.output;

import com.jacr.server.application.dto.ProfileDTO;
import com.jacr.server.application.ports.output.ProfilePersistencePort;
import com.jacr.server.domain.model.Profile;
import com.jacr.server.infrastructure.output.entity.ProfileEntity;
import com.jacr.server.infrastructure.output.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProfilePersistenceAdapter implements ProfilePersistencePort {

    private final ProfileRepository profileRepository;

    @Override
    public Profile save(Profile profile) {
        ProfileEntity profileEntity = toEntity(profile);
        if(profileEntity.getIsActive() == null){
            profileEntity.setIsActive(false);
        }
        ProfileEntity saveProfileEntity = profileRepository.save(profileEntity);

        return toProfile(saveProfileEntity);
    }

    public ProfileEntity toEntity(Profile profile){
      return ProfileEntity.builder()
              .id(profile.getId())
              .fullName(profile.getFullName())
              .email(profile.getEmail())
              .password(profile.getPassword())
              .profileImageUrl(profile.getProfileImageUrl())
              .createdAt(profile.getCreatedAt())
              .updatedAt(profile.getUpdatedAt())
              .activationToken(profile.getActivationToken())
              .build();
    }

    public Profile toProfile(ProfileEntity profileEntity){
        Profile profile = new Profile();

        profile.setId(profileEntity.getId());
        profile.setFullName(profileEntity.getFullName());
        profile.setEmail(profileEntity.getEmail());
        profile.setProfileImageUrl(profileEntity.getProfileImageUrl());
        profile.setCreatedAt(profileEntity.getCreatedAt());
        profile.setUpdatedAt(profileEntity.getUpdatedAt());
        return profile;

    }
}
