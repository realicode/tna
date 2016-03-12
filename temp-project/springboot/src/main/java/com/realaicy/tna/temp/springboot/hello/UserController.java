package com.realaicy.tna.temp.springboot.hello;

/**
 * Created by realaicy on 16/3/8.
 */

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final String template = "Hello, %s!,This is a page Need authotication";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/m1")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name,Authentication authentication) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name+" "+authentication.getName()));
    }
}
