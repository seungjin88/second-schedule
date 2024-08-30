package com.sparta.secondschedule.dto.comment.response;

import com.sparta.secondschedule.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentDetailResponseDto {

    private final Long id;
    private final String username;
    private final String contents;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public CommentDetailResponseDto(Comment comment) {
        this.id = comment.getId();
        this.username = comment.getUsername();
        this.contents = comment.getContents();
        this.createdDate = comment.getCreatedDate();
        this.modifiedDate = comment.getModifiedDate();
    }
}
