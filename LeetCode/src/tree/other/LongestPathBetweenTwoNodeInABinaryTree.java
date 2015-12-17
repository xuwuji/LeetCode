package tree.other;

import tree.easy.TreeNode;

/**
 * find the longest path between two nodes in a binary tree
 * 
 * @author xuwuji
 *
 */
public class LongestPathBetweenTwoNodeInABinaryTree {

	public int solution(TreeNode root) {
		if (root == null) {
			return -1;
		}

		int maxLeft = 0;
		int maxRight = 0;

		maxLeft = 1 + maxDepth(root.left);
		maxRight = 1 + maxDepth(root.right);

		int lLongPath = solution(root.left);
		int rLongPath = solution(root.right);

		return Math.max(Math.max(lLongPath, rLongPath), maxLeft + maxRight);
	}

	public int maxDepth(TreeNode pointer) {
		if (pointer == null) {
			return -1;
		}

		return 1 + Math.max(maxDepth(pointer.left), maxDepth(pointer.right));
	}
}
