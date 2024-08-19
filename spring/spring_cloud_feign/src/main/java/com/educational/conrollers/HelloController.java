package com.educational.conrollers;

import com.educational.clients.JSONPlaceHolderClient;
import com.educational.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/hello")
@RequiredArgsConstructor
public class HelloController {

    private final JSONPlaceHolderClient jsonPlaceHolderClient;

    @GetMapping
    public List<Post> get() {
        return jsonPlaceHolderClient.getPosts();
    }
}
