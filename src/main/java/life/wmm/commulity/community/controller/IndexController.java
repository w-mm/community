package life.wmm.commulity.community.controller;

import life.wmm.commulity.community.dto.QuestionDTO;
import life.wmm.commulity.community.model.Question;
import life.wmm.commulity.community.model.User;
import life.wmm.commulity.community.service.QuestionService;
import life.wmm.commulity.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @Autowired
    QuestionService questionService;

    @GetMapping("/")
    public String hello(HttpServletRequest request,Model model){
        Cookie[] cookies = request.getCookies();
        if (cookies !=null && cookies.length!=0){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    User user=userService.findByToken(token);
                    if (user!=null){
                        request.getSession().setAttribute("user",user);
                    }
                    break;

                }
            }
        }

        List<QuestionDTO> questionList=questionService.list();
        Model questionList1 = model.addAttribute("questionList", questionList);
        System.out.println(questionList1);

        return "index";
    }
}
