package com.ganster.challenge;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Paul Ganster on 9/18/2017.
 */
@Data
@Builder
public class Node {
    int value;
    Node left;
    Node right;
}
