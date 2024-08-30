package com.sparta.secondschedule.entity;

import com.sparta.secondschedule.dto.comment.request.CommentSaveRequestDto;
import com.sparta.secondschedule.dto.comment.request.CommentUpdateRequestDto;
import com.sparta.secondschedule.dto.comment.response.CommentDetailResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Comment extends Timestamped {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String contents;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public Comment (Schedule schedule, String username, String contents) {
        this.username = username;
        this.contents = contents;
        this.schedule = schedule;
    }

    public void update(CommentUpdateRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
}
