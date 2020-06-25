package com.ssh.article;

import com.ssh.article.dao.CommentRepository;
import com.ssh.article.po.Comment;
import com.ssh.article.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbDemoApplicationTests {
    @Autowired
    private CommentService commentService;
    @Test
    public void saveComment() {
        Comment comment = new Comment();
        comment.setArticleid("1002");
        comment.setContent("测试添加的数据");
        comment.setCreatedatetime(LocalDateTime.now());
        comment.setUserid("1004");
        comment.setNickname("李思思");
        comment.setState("1");
        comment.setLikenum(0);
        comment.setReplynum(0);
        comment.setParentid("3");
        commentService.saveComment(comment);
    }

    @Test
    public void findCommentListByParentid() {
        Page<Comment> page = commentService.findCommentListByParentid("3", 1, 2);
        System.out.println(page.getContent());
    }

    @Test
    public void updateCommentLikenum() {
        commentService.updateCommentLikenum("5ef4c7a4a4f63115cc4c3a4a");
    }
}
