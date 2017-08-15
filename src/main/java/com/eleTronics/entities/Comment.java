/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eleTronics.entities;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author nissanka
 */
@Getter
@Setter
public class Comment {

    private Integer id;
    private Post post;
    private String name;
    private String email;
    private String content;
    private Timestamp createdOn;

    public Comment(Integer id, int postId, String name, String email, String content, Timestamp createdOn) {
        this.id = id;
        this.name = name;
        this.post = new Post(postId);
        this.email = email;
        this.content = content;
        this.createdOn = createdOn;
    }
    
    
}
