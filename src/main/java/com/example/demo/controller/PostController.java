package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String showPage(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "index";
    }

    @PostMapping("/post")
    public String postContent(String content) {
    	Post post = new Post(content);
        postService.save(post);
        return "redirect:/";
    }
}
