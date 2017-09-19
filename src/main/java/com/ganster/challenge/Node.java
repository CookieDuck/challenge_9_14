package com.ganster.challenge;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * Created by Paul Ganster on 9/18/2017.
 */
@Data
@Builder
public class Node {
    @JsonProperty
    int value;

    @JsonProperty
    Node left;

    @JsonProperty
    Node right;

    int score;
    int depth;
}
