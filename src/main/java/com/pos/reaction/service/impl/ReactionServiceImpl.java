package com.pos.reaction.service.impl;

import com.pos.reaction.exception.ReactionNotFoundException;
import com.pos.reaction.model.Reaction;
import com.pos.reaction.repository.ReactionRepository;
import com.pos.reaction.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReactionServiceImpl implements ReactionService {

    @Autowired
    private ReactionRepository repository;

    public List<Reaction> getList() {
        return repository.findAll();
    }

    public Reaction getReaction(int reactionId) {
        return repository.findById(reactionId).orElseThrow(() -> new ReactionNotFoundException(reactionId));
    }

    public Reaction setReaction(Reaction newReaction, int reactionId) {
        return repository.findById(reactionId).map(reaction -> {
            reaction.setEmojiId(newReaction.getEmojiId());
            reaction.setUserId(newReaction.getUserId());
            reaction.setMessageId(newReaction.getMessageId());
            return repository.save(reaction);
        }).orElseGet(() ->{
            newReaction.setReactionId(reactionId);
            return repository.save(newReaction);
        });
    }

    public void clearReaction(int reactionId) {
        repository.deleteById(reactionId);
    }
}
