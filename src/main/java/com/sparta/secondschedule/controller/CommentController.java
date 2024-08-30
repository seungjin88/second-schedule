package com.sparta.secondschedule.controller;

import com.sparta.secondschedule.dto.comment.request.CommentSaveRequestDto;
import com.sparta.secondschedule.dto.comment.request.CommentUpdateRequestDto;
import com.sparta.secondschedule.dto.comment.response.CommentUpdateResponseDto;
import com.sparta.secondschedule.dto.comment.response.CommentDetailResponseDto;
import com.sparta.secondschedule.dto.comment.response.CommentSimpleResponseDto;
import com.sparta.secondschedule.dto.comment.response.CommentSaveResponseDto;
import com.sparta.secondschedule.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/schedules/{scheduleId}/comments")
    public CommentSaveResponseDto saveComment(@PathVariable Long scheduleId, @RequestBody CommentSaveRequestDto commentSaveRequestDto) {
        return commentService.saveComment(scheduleId, commentSaveRequestDto);
    }

    @GetMapping("/schedules/{scheduleId}/comments")
    public List<CommentSimpleResponseDto> getAllComments(@PathVariable Long scheduleId) {
        return commentService.getComments(scheduleId);
    }

    @GetMapping("/schedules/{scheduleId}/comments/{commentId}")
    public CommentDetailResponseDto getComments(@PathVariable Long commentId) {
        return commentService.getComment(commentId);
    }

    @PutMapping("/schedules/{scheduleId}/comments/{commentId}")
    public CommentUpdateResponseDto updateComments(@PathVariable Long scheduleId, @PathVariable Long commentId, @RequestBody CommentUpdateRequestDto commentSaveRequestDto) {
        return commentService.updateComments(scheduleId, commentId, commentSaveRequestDto);
    }

    @DeleteMapping("/schedules/{scheduleId}/comments/{commentId}")
    public void deleteComments(@PathVariable Long scheduleId, @PathVariable Long commentId) {
        commentService.deleteComments(scheduleId, commentId);
    }
}
