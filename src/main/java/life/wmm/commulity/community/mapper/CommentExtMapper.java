package life.wmm.commulity.community.mapper;

import life.wmm.commulity.community.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}