package com.kimyena.basicnoticeboard.reply.controller;

import com.kimyena.basicnoticeboard.crud.CRUDAbstractApiController;
import com.kimyena.basicnoticeboard.reply.db.ReplyEntity;
import com.kimyena.basicnoticeboard.reply.model.ReplyDto;
import com.kimyena.basicnoticeboard.reply.model.ReplyRequest;
import com.kimyena.basicnoticeboard.reply.service.ReplyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reply")
@RequiredArgsConstructor
public class ReplyApiController extends CRUDAbstractApiController<ReplyDto, ReplyEntity> {

/*    private final ReplyService replyService;

    @PostMapping("")
    public ReplyEntity create(
            @Valid
            @RequestBody ReplyRequest replyRequest
            ){
        return replyService.create(replyRequest);
    }*/


}
