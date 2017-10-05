package team.awesome.pet;

import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;  
  
@RestController  
public class HelloController {  
  
    @RequestMapping("/")  
    public String helloworld(){  
        return "Hello world yo!";  
    }  
      
    @RequestMapping("/hello/{name}")  
    public String hellName(@PathVariable String name){  
        return "Hello "+ name + " is AWESOME!";  
    }  
}  
