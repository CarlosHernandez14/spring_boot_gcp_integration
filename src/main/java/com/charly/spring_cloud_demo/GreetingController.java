package com.charly.spring_cloud_demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public Mono<String> greeting() {
        return Mono.just("Hola mundo desde spring boot parte 2!");
    }

}
