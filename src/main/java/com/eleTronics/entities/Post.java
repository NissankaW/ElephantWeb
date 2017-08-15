/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eleTronics.entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author nissanka
 */
@Getter
@Setter
@ToString
public class Post {

    private Integer id;
    private String title;
    private String content;
    private Timestamp createdOn;
    private List<Comment> comments = new ArrayList<>();

    public Post(Integer id) {
        this.id = id;
    }    

    public Post(Integer id, String title, String content, Timestamp createdOn) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdOn = createdOn;
    }

    public void addComment(@NonNull Comment comment) {
        comment.setPost(this);
        comments.add(comment);
    }
}
