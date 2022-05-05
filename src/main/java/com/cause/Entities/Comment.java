package com.cause.Entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Comment {
    @Id
    String _id;
    String content;
    String userId;
    String queryId;
    int size=0;

    public Comment(String content, String userId, String queryId) {
        this._id=queryId.substring(queryId.length()/2)+userId.substring(userId.length()/2)+(size++);
        this.content = content;
        this.userId = userId;
        this.queryId = queryId;
    }
}
