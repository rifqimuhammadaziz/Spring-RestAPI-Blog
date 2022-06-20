package rifqimuhammadaziz.springrestapiblog.service.contract;

import rifqimuhammadaziz.springrestapiblog.payload.CommentDto;

public interface CommentService {
    CommentDto createComment(Long postId, CommentDto commentDto);
}
