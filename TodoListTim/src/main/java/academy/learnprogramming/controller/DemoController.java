package academy.learnprogramming.controller;

import academy.learnprogramming.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

// http://localhost:8080/todo-list/

@Slf4j
@Controller
public class DemoController {
//    == Fields ==
    private final DemoService demoService;

//    == Constructors ==
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

//    == Request Methods ==
    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("welcome")
    public String welcome(Model model){
        model.addAttribute("helloMessage", demoService.getHelloMessage("Tomas"));
        log.info("model = {}", model);
        return "welcome";
    }

//    == Model Attributes ==
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcomeMessage() called");
        return demoService.getWelcomeMessage();
    }
}
