package life.wmm.commulity.community.service.serviceImpl;

import life.wmm.commulity.community.mapper.QuestionMapper;
import life.wmm.commulity.community.model.Question;
import life.wmm.commulity.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionMapper questionMapper;

    @Override
    public void creat(Question question) {
        questionMapper.creat(question);
    }
}
