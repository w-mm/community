package life.wmm.commulity.community.mapper;

import life.wmm.commulity.community.model.Question;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {

    public void creat(Question question);
}
