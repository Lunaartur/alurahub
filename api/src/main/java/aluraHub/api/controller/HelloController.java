package aluraHub.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @PostMapping
    public String olaMundo() {

        return "Hello World Spring Teste!";
    }
}
