package life.wmm.commulity.community.controller;


import life.wmm.commulity.community.dto.NotificationDTO;
import life.wmm.commulity.community.dto.PaginationDTO;
import life.wmm.commulity.community.dto.QuestionDTO;
import life.wmm.commulity.community.mapper.QuestionMapper;
import life.wmm.commulity.community.model.User;
import life.wmm.commulity.community.service.NotificationService;
import life.wmm.commulity.community.service.QuestionService;
import life.wmm.commulity.community.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    UserService userService;

    @Autowired
    QuestionService questionService;

    @Autowired
    private NotificationService notificationService;



    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action, Model model, HttpServletRequest request
            , @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "5") Integer size) {
        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            return "redirect:/";
        }

        if ("question".equals(action)) {
            List<QuestionDTO> questionDTOList = new ArrayList<>();
            model.addAttribute("section", "question");
            model.addAttribute("sectionName", "我的提问");
            PaginationDTO paginationDTO = questionService.list(user.getId(), page, size);
            model.addAttribute("paginationDTO", paginationDTO);

            questionDTOList.addAll(paginationDTO.getData());
            model.addAttribute("questionDTOList",questionDTOList);


        } else if ("replies".equals(action)) {
            List<NotificationDTO> notificationDTOList = new ArrayList<>();
            PaginationDTO paginationDTO=notificationService.list(user.getId(), page, size);
            Long unreadCount=notificationService.unreadCount(user.getId());
            model.addAttribute("section", "replies");
            model.addAttribute("paginationDTO", paginationDTO);
            model.addAttribute("sectionName", "我的最新回复");


            notificationDTOList.addAll(paginationDTO.getData());
            model.addAttribute("notificationDTOList",notificationDTOList);

        }
        return "profile";
    }
}
