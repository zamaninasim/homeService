package ir.maktab.service;

import ir.maktab.data.dao.CommentRepository;
import ir.maktab.data.model.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public void save(Comment comment) {
        commentRepository.save(comment);
    }
}
