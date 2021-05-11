/*
 * @(#) MaximumDepth.java 2021. 05. 11.
 *
 */
package com.tistory.ddoriya;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 이상준
 */
public class MaximumDepth {
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(1);
		tree.right = new TreeNode(4);
		tree.left.left = new TreeNode(5);
		tree.left.right = new TreeNode(8);
		tree.left.left.left = new TreeNode(7);

		MaximumDepth maximumDepth = new MaximumDepth();

		System.out.println(maximumDepth.bfs(tree));
		System.out.println(maximumDepth.dfs(tree));
	}

	public int bfs(TreeNode root) {
		if (root == null) return 0;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int count = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}

				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			count++;
		}

		return count;
	}

	public int dfs(TreeNode tree) {
		int max = 0;
		if (tree == null) return max;

		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> valueStack = new Stack<>();

		stack.push(tree);
		valueStack.push(1);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			int count = valueStack.pop();
			max = Math.max(max, count);

			if (node.left != null) {
				stack.push(node.left);
				valueStack.push(1 + count);
			}

			if (node.right != null) {
				stack.push(node.right);
				valueStack.push(1 + count);
			}
		}

		return max;
	}
}