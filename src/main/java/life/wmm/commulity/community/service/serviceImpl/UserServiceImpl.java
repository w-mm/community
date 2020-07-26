package life.wmm.commulity.community.service.serviceImpl;

import life.wmm.commulity.community.mapper.UserMapper;
import life.wmm.commulity.community.model.User;
import life.wmm.commulity.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }
}



