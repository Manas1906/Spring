package com.example.demo5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name) {
        return null;
    }

    @GetMapping("/greetings")
    public List<Greeting> getGreetings() {
        return greetingService.getGreetings();
    }

    @PostMapping("/greeting")
    public Greeting createGreeting(@RequestBody Greeting greeting) {
        return greetingService.createGreeting(greeting);
    }

    @PutMapping("/greeting/{id}")
    public Greeting updateGreeting(@PathVariable long id, @RequestBody Greeting greeting) {
        return greetingService.updateGreeting(id, greeting.getContent());
    }

    @DeleteMapping("/greeting/{id}")
    public String deleteGreeting(@PathVariable long id) {
        return greetingService.deleteGreeting(id) ? "Greeting deleted" : "Greeting not found";
    }
}
