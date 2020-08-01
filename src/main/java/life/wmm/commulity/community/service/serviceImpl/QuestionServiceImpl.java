package life.wmm.commulity.community.service.serviceImpl;

import life.wmm.commulity.community.dto.QuestionDTO;
import life.wmm.commulity.community.mapper.QuestionMapper;
import life.wmm.commulity.community.mapper.UserMapper;
import life.wmm.commulity.community.model.Question;
import life.wmm.commulity.community.model.User;
import life.wmm.commulity.community.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public void creat(Question question) {
        questionMapper.creat(question);
    }

    @Override
    public List<QuestionDTO> list() {
        List<Question> questionList=questionMapper.list();
        List<QuestionDTO> questionDTOList=new ArrayList<>();
        for (Question question:questionList){
            User user=userMapper.findById(question.getId());
            System.out.println(user);
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
