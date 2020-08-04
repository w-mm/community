package life.wmm.commulity.community.service;

import life.wmm.commulity.community.dto.PaginationDTO;
import life.wmm.commulity.community.model.Question;

public interface QuestionService {
    public void creat(Question question);

    PaginationDTO list(Integer page, Integer size);

    PaginationDTO list(Integer id, Integer page, Integer size);
}
