package com.ganster.challenge;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Paul Ganster on 9/18/2017.
 */
@Data
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Node {
    @JsonProperty
    int value;

    @JsonProperty
    Node left;

    @JsonProperty
    Node right;

    @JsonCreator
    public Node(
            @JsonProperty(value = "value") int value,
            @JsonProperty(value = "left") Node left,
            @JsonProperty(value = "right")Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @JsonIgnore
    int score;

    @JsonIgnore
    int depth;
}
