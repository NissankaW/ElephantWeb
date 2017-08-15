/*
 * This file is generated by jOOQ.
*/
package com.eleTronics.jooq.domain;


import com.eleTronics.jooq.domain.tables.Comments;
import com.eleTronics.jooq.domain.tables.Posts;
import com.eleTronics.jooq.domain.tables.records.CommentsRecord;
import com.eleTronics.jooq.domain.tables.records.PostsRecord;

import javax.annotation.Generated;

import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling foreign key relationships between tables of the <code>elephants</code> 
 * schema
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------

    public static final Identity<CommentsRecord, Integer> IDENTITY_COMMENTS = Identities0.IDENTITY_COMMENTS;
    public static final Identity<PostsRecord, Integer> IDENTITY_POSTS = Identities0.IDENTITY_POSTS;

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CommentsRecord> KEY_COMMENTS_PRIMARY = UniqueKeys0.KEY_COMMENTS_PRIMARY;
    public static final UniqueKey<PostsRecord> KEY_POSTS_PRIMARY = UniqueKeys0.KEY_POSTS_PRIMARY;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<CommentsRecord, PostsRecord> COMMENTS_IBFK_1 = ForeignKeys0.COMMENTS_IBFK_1;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Identities0 extends AbstractKeys {
        public static Identity<CommentsRecord, Integer> IDENTITY_COMMENTS = createIdentity(Comments.COMMENTS, Comments.COMMENTS.ID);
        public static Identity<PostsRecord, Integer> IDENTITY_POSTS = createIdentity(Posts.POSTS, Posts.POSTS.ID);
    }

    private static class UniqueKeys0 extends AbstractKeys {
        public static final UniqueKey<CommentsRecord> KEY_COMMENTS_PRIMARY = createUniqueKey(Comments.COMMENTS, "KEY_COMMENTS_PRIMARY", Comments.COMMENTS.ID);
        public static final UniqueKey<PostsRecord> KEY_POSTS_PRIMARY = createUniqueKey(Posts.POSTS, "KEY_POSTS_PRIMARY", Posts.POSTS.ID);
    }

    private static class ForeignKeys0 extends AbstractKeys {
        public static final ForeignKey<CommentsRecord, PostsRecord> COMMENTS_IBFK_1 = createForeignKey(com.eleTronics.jooq.domain.Keys.KEY_POSTS_PRIMARY, Comments.COMMENTS, "COMMENTS_ibfk_1", Comments.COMMENTS.POST_ID);
    }
}