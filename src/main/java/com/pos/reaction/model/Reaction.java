package com.pos.reaction.model;//package com.theboys.pos.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Reaction {

    @Id
    private int reactionId;
    private String emojiId;
    private int userId;
    private int messageId;
}
