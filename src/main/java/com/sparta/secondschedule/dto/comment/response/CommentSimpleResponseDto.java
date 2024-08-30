package com.sparta.secondschedule.dto.comment.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentSimpleResponseDto {

    private final Long id;
    private final String username;
    private final String contents;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public CommentSimpleResponseDto(Long id, String username, String contents, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.username = username;
        this.contents = contents;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
