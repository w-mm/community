package life.wmm.commulity.community.service;


import life.wmm.commulity.community.dto.CommentDTO;
import life.wmm.commulity.community.model.Comment;

import java.util.List;

public interface CommentService {

    void insert(Comment comment);

    List<CommentDTO> listByQuestionId(Long id);
}
