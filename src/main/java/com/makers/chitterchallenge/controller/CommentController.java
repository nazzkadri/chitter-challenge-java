package com.makers.chitterchallenge.controller;

import com.makers.chitterchallenge.model.Comment;
import com.makers.chitterchallenge.repository.ChitterRepository;
import com.makers.chitterchallenge.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ChitterRepository chitterRepository;

    @PostMapping("/api/chitters/{parent_chitter_id}/comments")
    public Comment Comment(@PathVariable(value= "parent_chitter_id") Long parent_chitter_id, @Valid @RequestBody Comment comment){
//            const chitter = chitterRepository.findById(parent_chitter_id)
//            comment.setParent();
//            return commentRepository.save(comment);

        comment.setParent(chitterRepository.findById(parent_chitter_id).get());
        return commentRepository.save(comment);
    }


}
