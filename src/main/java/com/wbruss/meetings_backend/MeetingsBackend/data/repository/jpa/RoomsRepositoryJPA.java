package com.wbruss.meetings_backend.MeetingsBackend.data.repository.jpa;

import com.wbruss.meetings_backend.MeetingsBackend.data.entity.RoomsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomsRepositoryJPA extends JpaRepository<RoomsEntity, Long> {

//    String findNameById(Long id);
}
