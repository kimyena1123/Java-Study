package com.kimyena.basicnoticeboard.reply.service;

import com.kimyena.basicnoticeboard.crud.CRUDAbstractService;
import com.kimyena.basicnoticeboard.post.db.PostEntity;
import com.kimyena.basicnoticeboard.post.db.PostRepository;
import com.kimyena.basicnoticeboard.reply.db.ReplyEntity;
import com.kimyena.basicnoticeboard.reply.db.ReplyRepository;
import com.kimyena.basicnoticeboard.reply.model.ReplyDto;
import com.kimyena.basicnoticeboard.reply.model.ReplyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService extends CRUDAbstractService<ReplyDto, ReplyEntity> {

    /*private final ReplyRepository replyRepository;
    private final PostRepository postRepository;

    //댓글 생성 - 해당 게시글에 대한 댓글 달기
    public ReplyEntity create(
            ReplyRequest replyRequest
    ){
        var postEntity = postRepository.findById(replyRequest.getPostId()).get();

        var entity = ReplyEntity.builder()
                .post(postEntity)
                .userName(replyRequest.getUserName())
                .password(replyRequest.getPassword())
                .status("REGISTERED")
                .title(replyRequest.getTitle())
                .content(replyRequest.getContent())
                .repliedAt(LocalDateTime.now())
                .build();

        return replyRepository.save(entity);
    }

    public List<ReplyEntity> findAllByPostId(Long postId) {
        return replyRepository.findAllByPostIdAndStatusOrderByIdDesc(postId, "REGISTERED");
    }*/


}
