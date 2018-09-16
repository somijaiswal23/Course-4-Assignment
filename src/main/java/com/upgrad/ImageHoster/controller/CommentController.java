package com.upgrad.ImageHoster.controller;


import com.upgrad.ImageHoster.model.Comment;

import com.upgrad.ImageHoster.model.User;

import com.upgrad.ImageHoster.service.CommentService;
import com.upgrad.ImageHoster.service.ImageService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;

import java.io.IOException;


public class CommentController {


    @Autowired

    private CommentService commentService;


    @Autowired

    private ImageService imageService;



    @RequestMapping(value = "/image/{id}/comments/create", method = RequestMethod.POST)

    public String newComment(@RequestParam("comment") String description, @PathVariable int id,

                             HttpSession session) throws IOException {

        User loggedInUser = (User) session.getAttribute("loggedInUser");


        imageService.getById(id);


        // if the user is not logged in, redirect to the signin page

        if (loggedInUser != null) {

            Comment comment = new Comment(description);

            commentService.saveComment(comment);

        } else {

            return "redirect:/signin";

        }

        return "redirect:/image/{id}";

    }


}