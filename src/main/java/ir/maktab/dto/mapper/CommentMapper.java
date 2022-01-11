package ir.maktab.dto.mapper;

import ir.maktab.data.model.entity.Comment;
import ir.maktab.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentMapper {
    private OrderMapper orderMapper;

    @Autowired
    public CommentMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public CommentDto commentToCommentDto(Comment comment) {
        return CommentDto.builder()
                .identificationNumber((comment.getId()) + 1000L)
                .score(comment.getScore())
                .opinion(comment.getOpinion())
                .orderDto(orderMapper.orderToOrderDto(comment.getOrder()))
                .build();

    }

    public Comment commentDtoToComment(CommentDto commentDto) {
        return Comment.builder()
                .id((int) ((commentDto.getIdentificationNumber()) - 1000L))
                .score(commentDto.getScore())
                .opinion(commentDto.getOpinion())
                .order(orderMapper.orderDtoToOrder(commentDto.getOrderDto()))
                .build();
    }

}
