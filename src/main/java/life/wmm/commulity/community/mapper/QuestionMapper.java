package life.wmm.commulity.community.mapper;

import life.wmm.commulity.community.model.Question;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {

    void creat(Question question);

    List<Question> list(Integer offset, Integer size);

    Integer count();

    List<Question> listByUserId(Integer userId, Integer offset, Integer size);

    Integer countByUserId(Integer userId);
}
