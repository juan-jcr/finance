package com.jacr.server.infrastructure.output.repository;

import com.jacr.server.infrastructure.output.entity.ProfileEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<ProfileEntity, Long> {

}
