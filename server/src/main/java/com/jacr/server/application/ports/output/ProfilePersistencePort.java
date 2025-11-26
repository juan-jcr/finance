package com.jacr.server.application.ports.output;

import com.jacr.server.domain.model.Profile;

public interface ProfilePersistencePort {
    Profile save(Profile profile);
}
