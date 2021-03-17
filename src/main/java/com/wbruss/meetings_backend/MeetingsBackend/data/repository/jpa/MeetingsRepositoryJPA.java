package com.wbruss.meetings_backend.MeetingsBackend.data.repository.jpa;

import com.wbruss.meetings_backend.MeetingsBackend.data.entity.MeetingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingsRepositoryJPA extends JpaRepository<MeetingsEntity, Long> {
}
