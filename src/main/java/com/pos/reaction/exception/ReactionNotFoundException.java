package com.pos.reaction.exception;

public class ReactionNotFoundException extends RuntimeException{

    public ReactionNotFoundException(int reactionId){
        super("Could not find reaction " + reactionId);
    }
}
