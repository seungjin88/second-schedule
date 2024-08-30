package com.sparta.secondschedule.controller;

import com.sparta.secondschedule.dto.schedule.request.ScheduleSaveRequestDto;
import com.sparta.secondschedule.dto.schedule.request.ScheduleUpdateRequestDto;
import com.sparta.secondschedule.dto.schedule.response.ScheduleDetailResponseDto;
import com.sparta.secondschedule.dto.schedule.response.ScheduleSaveResponseDto;
import com.sparta.secondschedule.dto.schedule.response.ScheduleUpdateResponseDto;
import com.sparta.secondschedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules") // C:create
    public ScheduleSaveResponseDto createSchedule(@RequestBody ScheduleSaveRequestDto requestDto) {
        return scheduleService.saveSchedule(requestDto);
    }

    @GetMapping("/schedules/{scheduleId}") // R:read
    public ScheduleDetailResponseDto getSchedule(@PathVariable Long scheduleId) {
        return scheduleService.getSchedule(scheduleId);
    }

    @PutMapping("/schedules/{scheduleId}") // U:update
    public ScheduleUpdateResponseDto updateSchedule(@PathVariable Long scheduleId, @RequestBody ScheduleUpdateRequestDto requestDto) {
        return scheduleService.updateSchedule(scheduleId, requestDto);
    }
}