package com.cause.Entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class Answer {
    @Id
    String _id;
    String answer;
    String userId;
    String date;
    String queryId;
    int score;
    static int size=0;

    public Answer(String answer, String userId,String date, String queryId) {
        this._id=queryId.substring(queryId.length()/2)+userId.substring(userId.length()/2)+(size++);
        this.answer = answer;
        this.userId = userId;
        this.queryId = queryId;
        this.score=0;
        this.date=date;
    }
}
