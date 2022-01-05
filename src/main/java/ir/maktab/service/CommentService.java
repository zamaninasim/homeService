package ir.maktab.service;

import ir.maktab.dao.CommentDao;
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
}
