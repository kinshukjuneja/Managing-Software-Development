
package pet.rescue.organization;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloWorld {

  @RequestMapping("/")
  public String home() {
    return "Hello World";
  }


  public static void main(String[] args) {
    SpringApplication.run(HelloWorld.class, args);
  }

}
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
//
// @Controller
// @EnableAutoConfiguration
// public class HelloWorld {
//
// @RequestMapping("/")
// @ResponseBody
// String home() {
// return "Hello World!";
// }
//
// public static void main(String[] args) throws Exception {
// String webPort = System.getenv("PORT");
// if ((webPort == null) || webPort.isEmpty()) {
// webPort = "8080";
// }
// System.setProperty("server.port", webPort);
// SpringApplication.run(HelloWorld.class, args);
// }
// }
//

