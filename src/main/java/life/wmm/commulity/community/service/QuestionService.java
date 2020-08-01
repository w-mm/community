package life.wmm.commulity.community.service;

import life.wmm.commulity.community.dto.QuestionDTO;
import life.wmm.commulity.community.model.Question;

import java.util.List;

public interface QuestionService {
    public void creat(Question question);

    List<QuestionDTO> list();
}
