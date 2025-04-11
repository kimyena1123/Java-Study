package com.kimyena.basicnoticeboard.post.service;

import com.kimyena.basicnoticeboard.board.db.BoardRepository;
import com.kimyena.basicnoticeboard.post.db.PostEntity;
import com.kimyena.basicnoticeboard.post.db.PostRepository;
import com.kimyena.basicnoticeboard.post.model.PostRequest;
import com.kimyena.basicnoticeboard.post.model.PostViewRequest;
import com.kimyena.basicnoticeboard.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;

    public PostEntity create(
            PostRequest postRequest
    ){
        var boardEntity = boardRepository.findById(postRequest.getBoardId()).get();  // 임시 고정
        var entity = PostEntity.builder()
                .board(boardEntity)
                .userName(postRequest.getUserName())
                .password(postRequest.getPassword())
                .email(postRequest.getEmail())
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .status("REGISTERED")
                .postedAt(LocalDateTime.now())
                .build();

        return postRepository.save(entity);
    }

    /*
    게시물(게시글) 한 개 보기 : 해당 게시물을 클릭하면, 비밀번호 입력 후 게시물을 볼 수 있다.
        1. 게시글이 있는가?
        2. 비밀번호가 맞는가?
     */
    public PostEntity view(PostViewRequest postViewRequest) {
        return postRepository.findFirstByIdAndStatusOrderByIdDesc(postViewRequest.getPostId(), "REGISTERED") //해당 게시물의 아이디를 찾아서
                .map(it->{
                    //entity 존재하는가
                    if(!it.getPassword().equals(postViewRequest.getPassword())) { //비밀번호가 틀리면,
                        var format = "패스워드가 맞지 않습니다. %s vs %s";
                        throw new RuntimeException(String.format(format, it.getPassword(), postViewRequest.getPassword()));
                    }

                    return it;

                }).orElseThrow(
                        () -> {
                            return new RuntimeException("해당 게시물이 존재하지 않습니다 : " + postViewRequest.getPostId());
                        }
                );
    }

    //게시물 전체 가져오기
    public List<PostEntity> all(){
        return postRepository.findAll();
    }

    //게시물 삭제하기: 비밀번호를 눌러야 삭제 가능함(view()메서드와 같이 비밀번호가 맞아야만 삭제가 가능하다.
    public void delete(PostViewRequest postViewRequest){
        postRepository.findById(postViewRequest.getPostId())
                .map( it -> {
                    //entity 존재하는가?
                    if(!it.getPassword().equals(postViewRequest.getPassword())) { //비밀번호가 틀리면
                        var format = "패스워드가 맞지 않습니다. %s vs %s";

                        throw new RuntimeException(String.format(format, it.getPassword(), postViewRequest.getPassword()));
                    }

                    //비밀번호가 맞다면
                    it.setStatus("UNREGISTERED"); //해지시켜준다.
                    postRepository.save(it);

                    return it;
                });
    }

}
