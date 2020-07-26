package life.wmm.commulity.community.service;

import life.wmm.commulity.community.model.User;

public interface UserService {
    void insert(User user);

    User findByToken(String token);
}
