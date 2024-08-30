package com.sparta.secondschedule.dto.schedule.request;

import lombok.Getter;

@Getter
public class ScheduleSaveRequestDto {
    private String username;
    private String title;
    private String contents;
}
