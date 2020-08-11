package life.wmm.commulity.community.service;

import life.wmm.commulity.community.dto.PaginationDTO;
import life.wmm.commulity.community.dto.QuestionDTO;
import life.wmm.commulity.community.model.Question;

public interface QuestionService {
    public void creat(Question question);

    PaginationDTO list(Integer page, Integer size);

    PaginationDTO list(Long id, Integer page, Integer size);

    QuestionDTO getById(Long id);

    void createOrUpdate(Question question);

    void incView(Long id);
}
