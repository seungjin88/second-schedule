package com.sparta.secondschedule.service;

import com.sparta.secondschedule.dto.comment.request.CommentSaveRequestDto;
import com.sparta.secondschedule.dto.comment.request.CommentUpdateRequestDto;
import com.sparta.secondschedule.dto.comment.response.CommentUpdateResponseDto;
import com.sparta.secondschedule.dto.comment.response.CommentDetailResponseDto;
import com.sparta.secondschedule.dto.comment.response.CommentSaveResponseDto;
import com.sparta.secondschedule.dto.comment.response.CommentSimpleResponseDto;
import com.sparta.secondschedule.entity.Comment;
import com.sparta.secondschedule.entity.Schedule;
import com.sparta.secondschedule.repository.CommentRepository;
import com.sparta.secondschedule.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;
    public CommentService (CommentRepository commentRepository, ScheduleRepository scheduleRepository) {
        this.commentRepository = commentRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @Transactional
    public CommentSaveResponseDto saveComment(Long scheduleId, CommentSaveRequestDto commentSaveRequestDto) {

        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new NullPointerException("댓글이 없습니다."));

        Comment newComment = new Comment(schedule, commentSaveRequestDto.getUsername(), commentSaveRequestDto.getContents());
        Comment savedComment = commentRepository.save(newComment);

        return new CommentSaveResponseDto(savedComment.getId(), savedComment.getUsername(), savedComment.getContents(),
                savedComment.getCreatedDate(), savedComment.getModifiedDate());
    }

    public List<CommentSimpleResponseDto> getComments(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new NullPointerException("댓글이 없습니다."));

        List<Comment> commentList = schedule.getComments();

        List<CommentSimpleResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            dtoList.add(new CommentSimpleResponseDto(comment.getId(), comment.getUsername(), comment.getContents(),
                    comment.getCreatedDate(), comment.getModifiedDate()));
        }
        return dtoList;
    }

    public CommentDetailResponseDto getComment(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new NullPointerException("댓글이 없습니다."));

        return new CommentDetailResponseDto(comment);
    }

    @Transactional
    public CommentUpdateResponseDto updateComments(Long scheduleId, Long commentId, CommentUpdateRequestDto commentUpdateRequestDto) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NullPointerException("댓글이 없습니다."));

        comment.update(commentUpdateRequestDto);

        Comment updatedComment = commentRepository.save(comment);

        return new CommentUpdateResponseDto(updatedComment.getId(), updatedComment.getUsername(), updatedComment.getContents(),
                updatedComment.getCreatedDate(), updatedComment.getModifiedDate());
    }

    @Transactional
    public void deleteComments(Long scheduleId, Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new NullPointerException("댓글이 없습니다."));

        commentRepository.delete(comment);

    }
}
