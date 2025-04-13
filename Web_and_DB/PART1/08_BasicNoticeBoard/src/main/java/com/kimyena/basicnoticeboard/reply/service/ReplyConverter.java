package com.kimyena.basicnoticeboard.reply.service;

import com.kimyena.basicnoticeboard.crud.Converter;
import com.kimyena.basicnoticeboard.post.db.PostRepository;
import com.kimyena.basicnoticeboard.reply.db.ReplyEntity;
import com.kimyena.basicnoticeboard.reply.model.ReplyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReplyConverter implements Converter<ReplyDto, ReplyEntity> {

    private final PostRepository postRepository;

    @Override
    public ReplyDto toDTO(ReplyEntity replyEntity) {
        //entity를 dto로 변환해야 한다. dto builder를 만들기
        return ReplyDto.builder()
                .id(replyEntity.getId())
                .postId(replyEntity.getPost().getId())
                .userName(replyEntity.getUserName())
                .password(replyEntity.getPassword())
                .status(replyEntity.getStatus())
                .title(replyEntity.getTitle())
                .content(replyEntity.getContent())
                .repliedAt(replyEntity.getRepliedAt())
                .build();
    }

    @Override
    public ReplyEntity toEntity(ReplyDto replyDto) {
        var postEntity = postRepository.findById(replyDto.getPostId());

        //dto를 entity로.
        return ReplyEntity.builder()
                .id(replyDto.getId()) //null이면 save(create)가 되고, null이 아니면 update가 될 것이다.
                .post(postEntity.orElse(null))
                .userName(replyDto.getUserName())
                .password(replyDto.getPassword())
                .status((replyDto.getStatus() != null) ? replyDto.getStatus() : "REGISTERED")
                .title(replyDto.getTitle())
                .content(replyDto.getContent())
                .repliedAt((replyDto.getRepliedAt() != null) ? replyDto.getRepliedAt() : LocalDateTime.now())
                .build();
    }
}
