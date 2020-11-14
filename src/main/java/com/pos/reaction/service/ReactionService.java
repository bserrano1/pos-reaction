package com.pos.reaction.service;

import com.pos.reaction.model.Reaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReactionService {

    List<Reaction> getList();

    Reaction getReaction(int reactionId);

    Reaction setReaction(Reaction newReaction, int reactionId);

    void clearReaction(int reactionId);
}
