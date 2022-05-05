package com.cause.Entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Question {
    @Id
    String _id;
    String userId;
    String title;
    String description;
    LocalDateTime date;
    List<String> groups;
    List<String> tags;
    List<Answer> answers;
    List<Comment> comments;
    int likes;

    public Question(String userId, String title, String description, List<String> groups, List<String> tags, List<Answer> answers, List<Comment> comments, int likes) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.date = LocalDateTime.now();
        this.groups = groups;
        this.tags = tags;
        this.answers = answers;
        this.comments = comments;
        this.likes = likes;
    }
}
