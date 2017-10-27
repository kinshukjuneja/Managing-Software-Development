package team.awesome.pet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories(basePackages = "team.awesome.pet.controller")
@SpringBootApplication
public class WebApplication {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(WebApplication.class, args);
  }
}
