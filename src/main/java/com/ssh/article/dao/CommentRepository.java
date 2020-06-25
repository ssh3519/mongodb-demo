package com.ssh.article.dao;

import com.ssh.article.po.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: ssh
 * @email: 18367183519@163.com
 * @Date: 2020/6/25 23:34
 */
@Repository
public interface CommentRepository extends MongoRepository<Comment,String> {
    Page<Comment> findByParentid(String parentid, Pageable pageable);
}
