package life.wmm.commulity.community.controller;


import life.wmm.commulity.community.dto.CommentDTO;
import life.wmm.commulity.community.dto.ResultDTO;
import life.wmm.commulity.community.mapper.CommentMapper;
import life.wmm.commulity.community.model.Comment;
import life.wmm.commulity.community.model.User;
import life.wmm.commulity.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;


/**
 * Created by codedrinker on 2019/5/30.
 */
@Controller
public class CommentController {

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post( CommentDTO commentDTO, HttpServletRequest request
                       ) {
        User user = (User) request.getSession().getAttribute("user");
//        if (user==null){
//            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
//        }
        Comment comment = new Comment();
        comment.setParentId(commentDTO.getParentId());
        comment.setContent(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setCommentator(5L);
        comment.setLikeCount(0L);
        commentService.insert(comment);
        return ResultDTO.okOf();
    }
}
