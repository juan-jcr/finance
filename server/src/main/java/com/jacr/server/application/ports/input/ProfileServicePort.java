package com.jacr.server.application.ports.input;

import com.jacr.server.application.dto.ProfileDTO;

public interface ProfileServicePort {
    public ProfileDTO registerProfile(ProfileDTO profileDTO);

}
