package life.wmm.commulity.community.service;


import life.wmm.commulity.community.dto.CommentDTO;
import life.wmm.commulity.community.enums.CommentTypeEnum;
import life.wmm.commulity.community.model.Comment;
import life.wmm.commulity.community.model.User;

import java.util.List;

public interface CommentService {

    void insert(Comment comment, User user);

    List<CommentDTO> listByTargetId(Long id, CommentTypeEnum type);
}
