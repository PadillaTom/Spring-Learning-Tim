package academy.learnprogramming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// http://localhost:8080/todo-list/

@Controller
public class DemoController {

    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("welcome")
    public String welcome(){
        return "welcome";
    }
}
