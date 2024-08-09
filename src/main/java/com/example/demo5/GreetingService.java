package com.example.demo5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public Greeting createGreeting(Greeting greeting) {
        return greetingRepository.save(greeting);
    }

    public List<Greeting> getGreetings() {
        return greetingRepository.findAll();
    }
    
    public Greeting getGreeting(long id) {
        return greetingRepository.findById(id).orElse(null);
    }

    public Greeting updateGreeting(long id, String name) {
        Greeting greeting = getGreeting(id);
        if (greeting != null) {
            greeting.setContent(String.format("Welcome, %s!", name));
            return greetingRepository.save(greeting);
        }
        return null;
    }

    public boolean deleteGreeting(long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
