package life.wmm.commulity.community.service;

import life.wmm.commulity.community.dto.NotificationDTO;
import life.wmm.commulity.community.dto.PaginationDTO;
import life.wmm.commulity.community.model.User;


public interface NotificationService {

    PaginationDTO list(Long id, Integer page, Integer size);
    public Long unreadCount(Long userId);
    public NotificationDTO read(Long id, User user);
}
