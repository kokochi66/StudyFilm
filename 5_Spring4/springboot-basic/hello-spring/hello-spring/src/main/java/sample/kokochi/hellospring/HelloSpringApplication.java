package sample.kokochi.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {
	//	톰캣 서버를 내장하고 있어서 자체적으로 서버를 실행시켜준다.
	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
