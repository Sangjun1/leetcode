/*
 * @(#) MaximumDepth.java 2021. 05. 11.
 *
 */
package com.tistory.ddoriya.test;

import com.tistory.ddoriya.MaximumDepth;
import com.tistory.ddoriya.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.assertj.core.api.Assertions.*;

/**
 * @author 이상준
 */

public class MaximumDepthTest {

	TreeNode tree;

	@BeforeEach
	void setUp() {
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(1);
		tree.right = new TreeNode(4);
		tree.left.left = new TreeNode(5);
		tree.left.right = new TreeNode(8);
		tree.left.left.left = new TreeNode(7);
	}

	@Test
	public void bfs_test() {
		assertThat(new MaximumDepth().bfs(tree)).isEqualTo(4);
	}

	@Test
	public void dfs_test() {
		assertThat(new MaximumDepth().dfs(tree)).isEqualTo(4);
	}
}