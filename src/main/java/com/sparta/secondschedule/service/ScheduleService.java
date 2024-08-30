package com.sparta.secondschedule.service;

import com.sparta.secondschedule.dto.schedule.request.ScheduleSaveRequestDto;
import com.sparta.secondschedule.dto.schedule.request.ScheduleUpdateRequestDto;
import com.sparta.secondschedule.dto.schedule.response.ScheduleDetailResponseDto;
import com.sparta.secondschedule.dto.schedule.response.ScheduleSaveResponseDto;
import com.sparta.secondschedule.dto.schedule.response.ScheduleUpdateResponseDto;
import com.sparta.secondschedule.entity.Schedule;
import com.sparta.secondschedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleSaveResponseDto saveSchedule(ScheduleSaveRequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto.getUsername(), requestDto.getTitle(), requestDto.getContents());
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleSaveResponseDto(savedSchedule.getId(), savedSchedule.getUsername(), savedSchedule.getTitle(),
                savedSchedule.getContents(), savedSchedule.getCreatedDate(), savedSchedule.getModifiedDate());
    }

    public ScheduleDetailResponseDto getSchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 할일이 존재하지 않습니다."));

        return new ScheduleDetailResponseDto(schedule.getId(), schedule.getUsername(), schedule.getTitle(),
                schedule.getContents(), schedule.getCreatedDate(), schedule.getModifiedDate());
    }

    @Transactional
    public ScheduleUpdateResponseDto updateSchedule(Long id, ScheduleUpdateRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 할일이 존재하지 않습니다."));
        schedule.update(requestDto.getUsername(), requestDto.getTitle(), requestDto.getContents());
        Schedule updatedSchedule = scheduleRepository.save(schedule);

        return new ScheduleUpdateResponseDto(updatedSchedule.getId(), updatedSchedule.getUsername(),
                updatedSchedule.getTitle(), updatedSchedule.getContents(), updatedSchedule.getCreatedDate(),
                updatedSchedule.getModifiedDate());
    }
}
