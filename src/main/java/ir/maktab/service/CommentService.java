package ir.maktab.service;

import ir.maktab.dao.CommentDao;
import ir.maktab.model.entity.Comment;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentDao commentDao;

    public void save(Comment comment) {
        commentDao.save(comment);
    }
}
