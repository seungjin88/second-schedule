package com.sparta.secondschedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "schedules")
@NoArgsConstructor
public class Schedule extends Timestamped{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String title;
    private String contents;


    @OneToMany(mappedBy = "schedule")
    private List<Comment> comments = new ArrayList<>();

    public Schedule(String username, String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;

    }

    public void update(String username, String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;
    }
}