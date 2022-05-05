package com.cause;

import com.cause.Entities.Question;
import com.cause.Entities.User;
import com.cause.Repos.QuesRepository;
import com.cause.Repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.List;
import java.util.Map;

@SpringBootApplication
public class CauseApplication {

	public static void main(String[] args) {

		SpringApplication.run(CauseApplication.class, args);
	}


//	@Bean
//	CommandLineRunner runner(UserRepository userRepository, QuesRepository quesRepository) {
//		return args -> {
//
//			User user = new User(
//					"test Sharma",
//					"test@gmail.com",
//					"creator",
//					"this is me God for this site...",
//					"123",
//					0L,
//					"https://bootdey.com/img/Content/avatar/avatar7.png",
//					"admin",
//					List.of("java", "reactJS", "python", "git", "spring-boot", "electrician"),
//					Map.of("portfolio","","resume","","linkedin","","github","","discord",""),
//					Map.of("codeforces","","codechef","","leetcode","","atCoders",""),
//					Map.of("Asked",30,"answers",1,"groupsJoined",0,"freq",100)
//			);
//			userRepository.findUserByEmail(user.getEmail()).ifPresentOrElse( s-> {
//				System.err.println("Already exists"+ user.getEmail());
//			}, () -> {
//				System.out.println("Interted User"+ user.getEmail());
//				userRepository.insert(user);
//			});
//
//			Question ques = new Question(
//					"625d889fa6770040a32b24c7",
//					"cause.com",
//					"What is cause.com? ",
//					List.of("cause.com","admin"),
//					List.of("english")
//			);
//			quesRepository.insert(ques);
//
// */
//
//		};
//	}

}
