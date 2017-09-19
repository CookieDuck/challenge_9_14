package com.ganster.challenge;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Paul Ganster on 9/18/2017.
 */
@RestController
@Slf4j
public class Controller {
    @PutMapping("/tree")
    public String getTopLevel(@RequestBody Node root) {
        log.info("Received {}", root);
        assignScoreAndDepth(root, 0, 1);
        Map<Integer, Node> nodeMap = new HashMap<>();
        addToMap(nodeMap, root);

        Set<Integer> keys = nodeMap.keySet();
        List<Integer> sortedKeys = keys.stream().collect(Collectors.toList());
        Collections.sort(sortedKeys);

        sortedKeys.stream().forEach(k -> log.info("Key {} has value: {}", k, nodeMap.get(k)));
        StringBuffer joiner = new StringBuffer();
        sortedKeys.stream().forEach(key -> joiner.append(nodeMap.get(key).getValue()));

        return joiner.toString();
    }

    private void assignScoreAndDepth(Node node, int scoreForNode, int depthForNode) {
        if (node == null)
            return;

        node.setScore(scoreForNode);
        node.setDepth(depthForNode);
        if (node.getLeft() != null)
            assignScoreAndDepth(node.getLeft(), scoreForNode - 1, depthForNode + 1);
        if (node.getRight() != null)
            assignScoreAndDepth(node.getRight(), scoreForNode + 1, depthForNode + 1);
    }

    private void addToMap(Map<Integer, Node> map, Node node) {
        if (node == null)
            return;

        if (!map.containsKey(node.getScore())) {
            map.put(node.getScore(), node);
        } else {
            Node current = map.get(node.getScore());
            if (node.getDepth() < current.getDepth()) {
                map.put(node.getScore(), node);
            }
        }

        addToMap(map, node.getLeft());
        addToMap(map, node.getRight());
    }
}
