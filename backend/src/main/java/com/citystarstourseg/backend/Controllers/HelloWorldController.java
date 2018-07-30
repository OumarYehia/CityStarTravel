package com.citystarstourseg.backend.Controllers;

import java.util.concurrent.atomic.AtomicLong;
import com.citystarstourseg.backend.Services.HelloWorldService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {

    private static final String template = "Hello, welcome to City Stars Tours Project%s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public HelloWorldService helloWorldService(@RequestParam(value="name", defaultValue="") String name) {
        return new HelloWorldService(counter.incrementAndGet(),
                String.format(template, name));
    }

}
