package com.kimyena.basicnoticeboard.board.service;

import com.kimyena.basicnoticeboard.board.db.BoardEntity;
import com.kimyena.basicnoticeboard.board.db.BoardRepository;
import com.kimyena.basicnoticeboard.board.model.BoardDto;
import com.kimyena.basicnoticeboard.board.model.BoardRequest;
import com.kimyena.basicnoticeboard.crud.CRUDAbstractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService extends CRUDAbstractService<BoardDto, BoardEntity> { //Service에서는 repository랑 연결시켜준다.

    /*private final BoardRepository boardRepository;
    private final BoardConverter boardConverter;

    public BoardDto create(
            BoardRequest boardRequest
    ){
        var entity = BoardEntity.builder()
                .boardName(boardRequest.getBoardName())
                .status("REGISTERED")
                .build();

        var saveEntity =  boardRepository.save(entity);
        return boardConverter.toDto(saveEntity);
    }

    public BoardDto view(Long id){
        var entity = boardRepository.findById(id).get();
        return boardConverter.toDto(entity);
    }
*/
}
