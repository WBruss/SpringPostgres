package com.wbruss.meetings_backend.MeetingsBackend.controllers;

import com.wbruss.meetings_backend.MeetingsBackend.data.dto.MeetingsEntityDto;
import com.wbruss.meetings_backend.MeetingsBackend.data.dto.MeetingsEntityDtoConverter;
import com.wbruss.meetings_backend.MeetingsBackend.data.entity.MeetingsEntity;
import com.wbruss.meetings_backend.MeetingsBackend.data.entity.RoomsEntity;
import com.wbruss.meetings_backend.MeetingsBackend.data.repository.MeetingsRepository;
import com.wbruss.meetings_backend.MeetingsBackend.data.repository.jpa.MeetingsRepositoryJPA;
import com.wbruss.meetings_backend.MeetingsBackend.data.repository.jpa.RoomsRepositoryJPA;
import com.wbruss.meetings_backend.MeetingsBackend.services.MeetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MeetingsController {

    @Autowired
    MeetingsRepositoryJPA meetingsRepositoryJPA;
//    @Autowired
    MeetingsRepository meetingsRepository;

    @Autowired
    RoomsRepositoryJPA roomsRepositoryJPA;

    @Autowired
    MeetingsService meetingsService;

    @GetMapping("/meetings")
    public ResponseEntity getAllMeetings() throws ParseException {
        System.out.println("**********  GET Meetings ***********");
        return  ResponseEntity.ok(meetingsService.getMeetings());
    }

    @GetMapping("/meetings/meeting")
    public ResponseEntity getMeetingById(@RequestParam(value = "id") Long id ) throws ParseException {
        System.out.println("********** Get Meeting ID: " + id +  " **********");
        return ResponseEntity.ok(meetingsService.getMeetingByID(id));
    }

    @PostMapping("/meetings")
    public ResponseEntity createMeeting(@RequestBody Map<String, String> meetingData) throws ParseException {
        System.out.println("*** Create Meeting ***");
        return ResponseEntity.ok(meetingsService.createMeetingService(meetingData));
    }


}
