package life.wmm.commulity.community.mapper;

import life.wmm.commulity.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void insert(User user);

    User findByToken(String token);

    User findById(Integer id);

    User findByAccountId(String accountId);

    void update(User user);
}
