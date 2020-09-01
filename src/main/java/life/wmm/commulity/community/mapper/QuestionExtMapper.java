package life.wmm.commulity.community.mapper;

;

import life.wmm.commulity.community.dto.QuestionQueryDTO;
import life.wmm.commulity.community.model.Question;

import java.util.List;

public interface QuestionExtMapper {
    int incView(Question record);

    int incCommentCount(Question record);

    List<Question> selectRelated(Question question);

    Integer countBySearch(QuestionQueryDTO questionQueryDTO);

    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}