package com.ganster.challenge;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Paul Ganster on 9/18/2017.
 */
@RunWith(JUnit4.class)
public class ControllerTest {
    private final Controller controller = new Controller();

    @Test
    public void test1() {
        Node root = Node.builder().
                value(1).
                left(Node.builder().value(2).left(
                        Node.builder().value(3).build()
                ).right(
                        Node.builder().value(4).build()
                ).build())
                .right(Node.builder().value(5).left(
                        Node.builder().value(6).build()
                ).right(
                        Node.builder().value(7).build()
                ).build()).build();
        String output = controller.getTopLevel(root);
        assertEquals("32157", output);
    }

    @Test
    public void test2() {
        
    }

    @Test
    public void test3() {

    }
}
