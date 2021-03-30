package com.padillalearning.bootdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class DemoController {

    @ResponseBody
    @GetMapping("demo")
    public String demo(){
        log.info("*** Demo() called ***");
        return "Hello from Spring Boot Demo";
    }

    @GetMapping("welcome")
    public String welcome(Model model){
        log.info("*** Welcome{} Called");
        model.addAttribute("Message", "Welcome from Welcome()");
        return "welcome";
    }

}
