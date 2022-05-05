package com.cause.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@Document
public class User {
    @Id
    String _id;
    String name;
    @Indexed(unique = true)
    String email;
    String profession;
    String description;
    String password;
    Long score;
    String profilePic;
    String role;
    List<String> specialization;
    Map<String, String> otherContractLinks;
    Map<String, String> otherPlatformLinks;
    Map<String, Integer> stats;
    List<Question> questions;

    public User(String _id, String name, String email, String profession, String description, String password, Long score, String profilePic, String role, List<String> specialization, Map<String, String> otherContractLinks, Map<String, String> otherPlatformLinks, Map<String, Integer> stats, List<Question> questions) {
        this._id = _id;
        this.name = name;
        this.email = email;
        this.profession = profession;
        this.description = description;
        this.password = password;
        this.score = score;
        this.profilePic = profilePic;
        this.role = role;
        this.specialization = specialization;
        this.otherContractLinks = otherContractLinks;
        this.otherPlatformLinks = otherPlatformLinks;
        this.stats = stats;
        this.questions = questions;
    }
}
