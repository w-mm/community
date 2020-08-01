package life.wmm.commulity.community.controller;


import life.wmm.commulity.community.dto.AccessTokenDTO;
import life.wmm.commulity.community.dto.GithubUser;
import life.wmm.commulity.community.mapper.UserMapper;
import life.wmm.commulity.community.model.User;
import life.wmm.commulity.community.provider.GithubProvider;
import life.wmm.commulity.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Autowired
    private UserService userService;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletResponse response)
    {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);

        if (user!=null && user.getId() !=null){
            User user1 = new User();
            String token = UUID.randomUUID().toString();
            user1.setToken(token);
            user1.setName(user.getName());
            user1.setAccountId(String.valueOf(user.getId()));
            user1.setGmtCreat(System.currentTimeMillis());
            user1.setGmtModified(user1.getGmtCreat());
            user1.setAvatarUrl(user.getAvatar_url());

            System.out.println(user);

            userService.insert(user1);
            response.addCookie(new Cookie("token",token));
            //登陆成功写cookie和session
//
            return "redirect:/";
        }else {
            //登陆失败，重新登陆
            return "redirect:/";
        }


    }
}
