package com.realaicy.tna.temp.springboot.hello;

/**
 * Created by realaicy on 16/3/8.
 */
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name+" "+auth.getName()+" "));
    }
}
