package com.whiteship.practice.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    BinarySearchTree binarySearchTree;

    @BeforeEach
    void setup() {
        binarySearchTree = new BinarySearchTree();
        binarySearchTree.addNode(10);
        binarySearchTree.addNode(5);
        binarySearchTree.addNode(1);
        binarySearchTree.addNode(7);
        binarySearchTree.addNode(6);
        binarySearchTree.addNode(8);
        binarySearchTree.addNode(11);
        binarySearchTree.addNode(13);
        binarySearchTree.addNode(12);
        binarySearchTree.addNode(17);
    }

    @Test
    @DisplayName("bfs를 테스트한다.")
    void bfsTest() {
        List<Integer> actual = binarySearchTree.bfs(binarySearchTree.root);
        List<Integer> bfsExpected = new ArrayList<Integer>();
        bfsExpected.add(10);
        bfsExpected.add(5);
        bfsExpected.add(11);
        bfsExpected.add(1);
        bfsExpected.add(7);
        bfsExpected.add(13);
        bfsExpected.add(6);
        bfsExpected.add(8);
        bfsExpected.add(12);
        bfsExpected.add(17);

        assertEquals(bfsExpected, actual);
    }

    @Test
    @DisplayName("dfs를 테스트한다.")
    void dfsTest() {
        List<Integer> actual = binarySearchTree.dfs(binarySearchTree.root);
        List<Integer> dfsExpected = new ArrayList<Integer>();
        dfsExpected.add(10);
        dfsExpected.add(5);
        dfsExpected.add(1);
        dfsExpected.add(7);
        dfsExpected.add(6);
        dfsExpected.add(8);
        dfsExpected.add(11);
        dfsExpected.add(13);
        dfsExpected.add(12);
        dfsExpected.add(17);

        assertEquals(dfsExpected, actual);
    }

    @Test
    @DisplayName("트리의 노드를 삭제한다.")
    void deleteNodeTest() {
        binarySearchTree.search(17);
        binarySearchTree.deleteNode(17);
        binarySearchTree.search(17);

        binarySearchTree.search(10);
        binarySearchTree.deleteNode(10);
        binarySearchTree.search(10);
    }


}