package com.ganster.challenge;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Paul Ganster on 9/18/2017.
 */
@RestController
public class Controller {

    @PutMapping("/tree")
    public String getTopLevel(Node root) {
        return null;
    }
}
