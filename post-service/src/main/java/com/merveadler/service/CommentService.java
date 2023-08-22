package com.merveadler.service;

import com.merveadler.repository.ICommentRepository;
import com.merveadler.repository.entity.Comment;
import com.merveadler.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class CommentService extends ServiceManager<Comment, String> {

    private final ICommentRepository commentRepository;

    public CommentService(ICommentRepository commentRepository) {
        super(commentRepository);
        this.commentRepository = commentRepository;
    }
}
