package ir.maktab.service;

import ir.maktab.data.dao.CommentRepository;
import ir.maktab.data.model.entity.Comment;
import ir.maktab.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    @Override
    public void save(CommentDto commentDto) {
        Comment comment = modelMapper.map(commentDto, Comment.class);
        commentRepository.save(comment);
    }
}
