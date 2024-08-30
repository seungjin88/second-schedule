package com.sparta.secondschedule.dto.schedule.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleDetailResponseDto {

    private final Long id;
    private final String username;
    private final String title;
    private final String contents;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public ScheduleDetailResponseDto(Long id, String username, String title, String contents, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
