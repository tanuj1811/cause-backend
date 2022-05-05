package com.cause.Services;

import com.cause.Entities.Answer;
import com.cause.Entities.Comment;
import com.cause.Entities.Question;
import com.cause.Entities.User;
import com.cause.Repos.QuesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class QuesService {
    private QuesRepository quesRepository;
    private UserService userService;

    public List<Question>  fetchAllUser() {
        return quesRepository.findAll();
    }

    public Question fetchQueryById(String queryId) {
        return quesRepository.findBy_id(queryId);
    }

    public void addQuery(Question ques) {
        Question addQues = new Question(
                ques.getUserId(),ques.getTitle(), ques.getDescription(), ques.getGroups(),ques.getTags(),new ArrayList<>(),new ArrayList<>(),0
        );
        quesRepository.insert(addQues);
        User user = userService.fetchUserById(addQues.getUserId());
        Question query= quesRepository.findBy_id(addQues.get_id());
        List<Question> q=user.getQuestions();
        q.add(query);
        user.setQuestions(q);
//        System.out.println("Query add succesfully from both side" + query);
        userService.updateUser(user);
    }

    public Question deleteQuery(String id) {
        Question question=quesRepository.findBy_id(id);
        User user= userService.fetchUserById(question.getUserId());
        userService.delete(question);
        quesRepository.delete(question);
        return question;
    }

    public void updateQuery(Question newQues) {
        System.out.println("updating ... query" + newQues.get_id());
        Question ques= quesRepository.findBy_id(newQues.get_id());
        quesRepository.deleteById(newQues.get_id());
        quesRepository.insert(newQues);
        User user= userService.fetchUserById(newQues.getUserId());
        List<Question> q=user.getQuestions();
        q.remove(ques);
        q.add(newQues);
        user.setQuestions(q);
        userService.updateUser(user);
    }

//    comment services
    public List<Comment> fetchAllComments(String queryId) {
        Question ques= quesRepository.findBy_id(queryId);
        return ques.getComments();
    }
    public void deleteComment(Comment comment) {
        Question ques = quesRepository.findBy_id(comment.getQueryId());
        List<Comment>  comments = ques.getComments();
        comments.remove(comment);
        ques.setComments(comments);
        updateQuery(ques);
    }
    public Comment deleteComment(String queryId, String commentId) {
        Question ques = quesRepository.findBy_id(queryId);
        List<Comment>  comments = ques.getComments();
        Comment comment=null;
        for(Comment c:comments) {
            if(c.get_id().equals(commentId)) {
                comment=c;
                break;
            }
        }
        if(comment!=null) {
            System.out.println("Commet deleted success"+ comment.get_id());
            comments.remove(comment);
            ques.setComments(comments);
            updateQuery(ques);
        }
        return comment;
    }
    public void addComment(Comment comment) {
        Question ques = quesRepository.findBy_id(comment.getQueryId());
        List<Comment>  comments = ques.getComments();
        comments.add(0,comment);
        ques.setComments(comments);
        updateQuery(ques);
    }

//    All answers services
    public List<Answer> fetchAllAnswers(String queryId) {
        Question ques= quesRepository.findBy_id(queryId);
        return ques.getAnswers();
    }
    public Answer deleteAnswer(String queryId, String answerId) {
        Question ques = quesRepository.findBy_id(queryId);
        List<Answer>  answers = ques.getAnswers();
        Answer answer= null;
        for(Answer ans:answers) {
            if(ans.get_id().equals(answerId)) {
                answer=ans;
                break;
            }
        }
        if(answer!=null) {
            System.out.println("answer deleted success"+ answer.get_id());
            answers.remove(answer);
            ques.setAnswers(answers);
            updateQuery(ques);
        }
        return answer;
    }
    public void addAnswer(Answer answer) {
        Question ques = quesRepository.findBy_id(answer.getQueryId());
        List<Answer>  answers = ques.getAnswers();
        answers.add(0,answer);
        ques.setAnswers(answers);
        updateQuery(ques);
    }

    public Answer updateAnswer(Answer newAnswer) {
        Question ques=quesRepository.findBy_id(newAnswer.getQueryId());
        List<Answer> answers= (List<Answer>) ques.getAnswers().stream().filter((e)->e.get_id()!=newAnswer.get_id());
        answers.add(newAnswer);
        ques.setAnswers(answers);
        updateQuery(ques);

        return newAnswer;
    }

}
