package com.kimyena.basicnoticeboard.post.service;

import com.kimyena.basicnoticeboard.board.db.BoardRepository;
import com.kimyena.basicnoticeboard.common.Api;
import com.kimyena.basicnoticeboard.common.Pagination;
import com.kimyena.basicnoticeboard.crud.CRUDAbstractService;
import com.kimyena.basicnoticeboard.post.db.PostEntity;
import com.kimyena.basicnoticeboard.post.db.PostRepository;
import com.kimyena.basicnoticeboard.post.model.PostDto;
import com.kimyena.basicnoticeboard.post.model.PostRequest;
import com.kimyena.basicnoticeboard.post.model.PostViewRequest;
import com.kimyena.basicnoticeboard.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService extends CRUDAbstractService<PostDto, PostEntity> {

    /*private final PostRepository postRepository;
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

    *//*
    게시물(게시글) 한 개 보기 : 해당 게시물을 클릭하면, 비밀번호 입력 후 게시물을 볼 수 있다.
        1. 게시글이 있는가?
        2. 비밀번호가 맞는가?
     *//*
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
    public Api<List<PostEntity>> all(Pageable pageable){
        var list = postRepository.findAll(pageable);

        var pagination = Pagination.builder()
                .page(list.getNumber()) //현재 몇번째 페이지에 있는지
                .size(list.getSize())
                .currentElements(list.getNumberOfElements()) //현재 몇개 가지고 있는지 -> 현재 페이지에 있는 element의 개수를 보여준다.
                .totalElements(list.getTotalElements()) //주의) totalElements는 Long 타입이다.전체 개수가 많을 수 있기 떄문에 Integer가 아니라 Long으로 받아줘야 햔다.
                .totalPage(list.getTotalPages())
                .build();

        var response = Api.<List<PostEntity>>builder()
                .body(list.toList())
                .pagination(pagination)
                .build();

        return response;
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
    }*/

}
