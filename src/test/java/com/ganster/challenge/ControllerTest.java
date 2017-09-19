package com.ganster.challenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Paul Ganster on 9/18/2017.
 */
@RunWith(JUnit4.class)
public class ControllerTest {
    private final Controller controller = new Controller();

    private final ObjectMapper objectMapper = new ObjectMapper();

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
    public void test2() throws IOException {
//        Node root = Node.builder().
//                value(1).
//                left(Node.builder().value(2).left(
//                        Node.builder().value(3).build()
//                ).right(
//                        Node.builder().value(4).build()
//                ).build())
//                .right(Node.builder().value(5).left(
//                        Node.builder().value(6).build()
//                ).right(
//                        Node.builder().value(7).build()
//                ).build()).build();

        Node root = objectMapper.readValue("{\n" +
                "  \"value\": 6,\n" +
                "  \"left\": {\n" +
                "    \"value\": 3,\n" +
                "    \"left\": {\n" +
                "      \"value\": 4,\n" +
                "      \"left\": null,\n" +
                "      \"right\": null\n" +
                "    },\n" +
                "    \"right\": {\n" +
                "      \"value\": 5,\n" +
                "      \"left\": null,\n" +
                "      \"right\": null\n" +
                "    }\n" +
                "  },\n" +
                "  \"right\": {\n" +
                "    \"value\": 7,\n" +
                "    \"left\": null,\n" +
                "    \"right\": null\n" +
                "  }\n" +
                "}", Node.class);
        String output = controller.getTopLevel(root);
        assertEquals("4367", output);
    }

    @Test
    public void test3() throws IOException {
        Node root = objectMapper.readValue("{\n" +
                "  \"value\": 10,\n" +
                "  \"left\": {\n" +
                "    \"value\": 9,\n" +
                "    \"left\": {\n" +
                "      \"value\": 7,\n" +
                "      \"left\": null,\n" +
                "      \"right\": null\n" +
                "    },\n" +
                "    \"right\": {\n" +
                "      \"value\": 6,\n" +
                "      \"left\": {\n" +
                "        \"value\": 5,\n" +
                "        \"left\": null,\n" +
                "        \"right\": null\n" +
                "      },\n" +
                "      \"right\": {\n" +
                "        \"value\": 4,\n" +
                "        \"left\": {\n" +
                "          \"value\": 3,\n" +
                "          \"left\": null,\n" +
                "          \"right\": null\n" +
                "        },\n" +
                "        \"right\": {\n" +
                "          \"value\": 2,\n" +
                "          \"left\": null,\n" +
                "          \"right\": null\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"right\": {\n" +
                "    \"value\": 8,\n" +
                "    \"left\": null,\n" +
                "    \"right\": null\n" +
                "  }\n" +
                "}", Node.class);
        String output = controller.getTopLevel(root);
        assertEquals("791082", output);
    }
}
