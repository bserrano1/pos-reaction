package com.pos.reaction.controller;

import com.pos.reaction.model.Reaction;
import com.pos.reaction.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/reactions")
public class ReactionController {

    @Autowired
    private ReactionService service;

    @GetMapping
    public List<Reaction> all(){
        return service.getList();
    }

    @GetMapping(value = "/{reactionId}")
    public Reaction getReaction(@PathVariable int reactionId) {
        return service.getReaction(reactionId);
    }

    @PutMapping(value = "/{reactionId}")
    public Reaction putReaction(@RequestBody Reaction newReaction, @PathVariable int reactionId) {
        return service.setReaction(newReaction, reactionId);
    }

    @DeleteMapping("/{reactionId}")
    public void deleteReaction(@PathVariable int reactionId){
        service.clearReaction(reactionId);
    }

}
