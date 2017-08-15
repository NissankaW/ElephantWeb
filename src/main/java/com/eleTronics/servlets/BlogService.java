/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eleTronics.servlets;

/**
 *
 * @author nissanka
 */
import com.eleTronics.entities.Post;
import com.eleTronics.entities.Comment;
import static com.eleTronics.jooq.domain.tables.Comments.COMMENTS;
import static com.eleTronics.jooq.domain.tables.Posts.POSTS;
import com.eleTronics.jooq.domain.tables.records.CommentsRecord;
import com.eleTronics.jooq.domain.tables.records.PostsRecord;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class BlogService {

    @Autowired
    private DSLContext dsl;

    public Post createPost(Post post) {
        PostsRecord postsRecord = dsl.insertInto(POSTS)
                .set(POSTS.TITLE, post.getTitle())
                .set(POSTS.CONTENT, post.getContent())
                .set(POSTS.CREATED_ON, post.getCreatedOn())
                .returning(POSTS.ID)
                .fetchOne();

        post.setId(postsRecord.getId());
        return post;
    }

    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        System.out.println("DSLL>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(dsl);
        Result<Record> result = dsl.select().from(POSTS).fetch();
        result.forEach((r) -> {
            posts.add(getPostEntity(r));
        });
        return posts;
    }

    public Post getPost(int postId) {
        Record record = dsl.select().
                from(POSTS)
                .where(POSTS.ID.eq(postId))
                .fetchOne();
        if (record != null) {
            Post post = getPostEntity(record);

            Result<Record> commentRecords = dsl.select().
                    from(COMMENTS)
                    .where(COMMENTS.POST_ID.eq(postId))
                    .fetch();

            for (Record r : commentRecords) {
                post.addComment(getCommentEntity(r));
            }
            return post;
        }
        return null;
    }

    public Comment createComment(Comment comment) {
        CommentsRecord commentsRecord = dsl.insertInto(COMMENTS)
                .set(COMMENTS.POST_ID, comment.getPost().getId())
                .set(COMMENTS.NAME, comment.getName())
                .set(COMMENTS.EMAIL, comment.getEmail())
                .set(COMMENTS.CONTENT, comment.getContent())
                .set(COMMENTS.CREATED_ON, comment.getCreatedOn())
                .returning(COMMENTS.ID)
                .fetchOne();

        comment.setId(commentsRecord.getId());
        return comment;
    }

    public void deleteComment(Integer commentId) {
        dsl.deleteFrom(COMMENTS)
                .where(COMMENTS.ID.equal(commentId))
                .execute();
    }

    private Post getPostEntity(Record r) {
        Integer id = r.getValue(POSTS.ID, Integer.class);
        String title = r.getValue(POSTS.TITLE, String.class);
        String content = r.getValue(POSTS.CONTENT, String.class);
        Timestamp createdOn = r.getValue(POSTS.CREATED_ON, Timestamp.class);
        return new Post(id, title, content, createdOn);
    }

    private Comment getCommentEntity(Record r) {
        Integer id = r.getValue(COMMENTS.ID, Integer.class);
        Integer postId = r.getValue(COMMENTS.POST_ID, Integer.class);
        String name = r.getValue(COMMENTS.NAME, String.class);
        String email = r.getValue(COMMENTS.EMAIL, String.class);
        String content = r.getValue(COMMENTS.CONTENT, String.class);
        Timestamp createdOn = r.getValue(COMMENTS.CREATED_ON, Timestamp.class);
        return new Comment(id, postId, name, email, content, createdOn);
    }
}
