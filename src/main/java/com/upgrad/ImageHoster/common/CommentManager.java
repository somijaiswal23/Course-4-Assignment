package com.upgrad.ImageHoster.common;


import com.upgrad.ImageHoster.model.Comment;

import com.upgrad.ImageHoster.model.Image;

import org.hibernate.Session;


public class CommentManager extends SessionManager {


      public void saveComment(final Comment comment) {

        Session session = openSession();

        session.save(comment);

        commitSession(session);

    }

}