package com.cause.Services;

import com.cause.Entities.Question;
import com.cause.Entities.User;
import com.cause.Repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;

    @ModelAttribute
    public void getActiveUser(Model model, Principal principal) {
        User user = userRepository.findUserByEmail(principal.getName());
        model.addAttribute("user",user);
    }
    public User addUser(User user){
        userRepository.insert(user);
        return user;
    }
    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    public User fetchUserById(String userId) {
        return userRepository.findUserBy_id(userId);
    }
    public boolean updateUser(User user) {
        try {
            userRepository.deleteById(user.get_id());
            userRepository.insert(user);
            System.out.println("update successfully");
            return true;
        } catch (Exception e) {
            System.err.println("ERROR !!!" + e.getMessage());
            return false;
        }
    }
    public void delete(User user) {userRepository.delete(user);}
    public void delete(String userId) {userRepository.deleteById(userId);}
    public void delete(Question ques) {
        try {
            User user = userRepository.findUserBy_id(ques.getUserId());
            user.getQuestions().remove(ques);
            updateUser(user);
        } catch (Exception e) {
            System.err.println("ERROR !!!" + e.getMessage());
        }
    }

    public List<Question> fetchAllQueries(String userId) {return userRepository.findUserBy_id(userId).getQuestions();}

}
