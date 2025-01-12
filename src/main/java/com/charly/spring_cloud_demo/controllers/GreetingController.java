package com.charly.spring_cloud_demo.controllers;


import com.charly.spring_cloud_demo.entities.UserDTO;
import com.charly.spring_cloud_demo.entities.UserEntity;
import com.charly.spring_cloud_demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final UserRepository userRepository;

    @Autowired
    public GreetingController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public Mono<String> greeting() {
        return Mono.just("Hola mundo desde spring boot parte 2!");
    }

    @GetMapping("/users")
    public Flux<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public Mono<UserEntity> createUser(@RequestBody UserDTO userDTO) {
        return Mono.just(userDTO)
                .map(user -> UserEntity.builder()
                        .firstName(user.firstName())
                        .lastName(user.lastName())
                        .age(user.age())
                        .email(user.email())
                        .build())
                .flatMap(userRepository::save);
    }

}
