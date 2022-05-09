package com.cause.Controllers;

import com.cause.Entities.Answer;
import com.cause.Entities.Comment;
import com.cause.Entities.Question;
import com.cause.Services.QuesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin(origins = "https://cause-one.vercel.app/")
@RestController
@RequestMapping("api/queries")
@AllArgsConstructor
public class QuestionController {

    private QuesService quesService;
    @GetMapping
    public List<Question> fetchAllQueries() {return quesService.fetchAllUser();}

    @GetMapping("/{queryId}")
    public Question fetchQuery(@PathVariable String queryId) {return quesService.fetchQueryById(queryId);}

    @PostMapping("/newQuery")
    public void addQuery(@RequestBody Question ques) {
        quesService.addQuery(ques);
    }

    @DeleteMapping("/{queryId}")
    public Question deleteQuery(@PathVariable String queryId){
        return quesService.deleteQuery(queryId);
    }

    @PostMapping("/{queryId}/updateQuery")
    public void updateQuery(@RequestBody Question ques,@PathVariable String queryId) {
        ques.set_id(queryId);
        quesService.updateQuery(ques);
    }


/**
 * Comments Controllers
 */
    @PostMapping("/{queryId}/addComment")
    public void addComment(@RequestBody Comment comment) {
        quesService.addComment(comment);
    }

    @DeleteMapping("/{queryId}/{commentId}")
    public void deleteComment(@PathVariable String queryId,@PathVariable String commentId) {
        quesService.deleteComment(queryId,commentId);
    }

    /**
     * Answers Controlller
     * @param answer
     * @return
     */
    @PostMapping("/{queryId}/addAnswer")
    public Answer addAnswer(@RequestBody Answer answer) {
        quesService.addAnswer(answer);
        return answer;
    }
    @PostMapping("/{queryId}/ans/{answerId}")
    public Answer updateAnswer(@RequestBody Answer newAnswer) {
        return quesService.updateAnswer(newAnswer);
    }

    @DeleteMapping("/{queryId}/ans/{answerId}")
    public Answer deleteAnswer(@PathVariable String answerId, @PathVariable String queryId) {
        return quesService.deleteAnswer(queryId,answerId);
    }

}

