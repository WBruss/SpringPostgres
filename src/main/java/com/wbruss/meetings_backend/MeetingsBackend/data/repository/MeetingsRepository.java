package com.wbruss.meetings_backend.MeetingsBackend.data.repository;

import com.wbruss.meetings_backend.MeetingsBackend.data.dto.MeetingsEntityDto;
import com.wbruss.meetings_backend.MeetingsBackend.data.entity.MeetingObj;
import com.wbruss.meetings_backend.MeetingsBackend.data.entity.MeetingsEntity;

import java.text.ParseException;
import java.util.List;

public interface MeetingsRepository {
    List<MeetingsEntityDto> getMeetings() throws ParseException;
}
