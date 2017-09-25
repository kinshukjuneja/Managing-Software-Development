package team.awesome.pet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan("team.awesome.pet")
@SpringBootApplication
@RestController
public class WebApplication {
  @RequestMapping("/")
  public String home() {
    return "Hello World";
  }


  public static void main(String[] args) throws Exception {
    SpringApplication.run(WebApplication.class, args);
  }
}
