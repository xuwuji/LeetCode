package tree.other;

import tree.easy.TreeNode;

/**
 * find the shortest path between two nodes in a binary tree
 * 
 * 1.find the lowest common ancestor
 * 
 * 2. find each shortest path from the node to the ancestor and add them
 * together
 * 
 * @author xuwuji
 *
 */
public class ShortestPathBetweenTwoNodes {

	public TreeNode FindTheAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}

		if (p == root) {
			return p;
		}

		if (q == root) {
			return q;
		}

		TreeNode left = FindTheAncestor(root.left, p, q);
		TreeNode right = FindTheAncestor(root.right, p, q);

		if (left == null && right == null) {
			return null;
		}

		if (left != null && right == null) {
			return left;
		}

		if (right != null && left == null) {
			return right;
		}

		return root;
	}

	public int PathBetweenRootToNode(TreeNode root, TreeNode p) {
		if (root == null) {
			return -1;
		}

		if (root == p) {
			return 0;
		}

		if (root.left == null) {
			return 1 + PathBetweenRootToNode(root.right, p);
		}

		if (root.right == null) {
			return 1 + PathBetweenRootToNode(root.left, p);
		}

		return 1 + Math.min(PathBetweenRootToNode(root.left, p), PathBetweenRootToNode(root.right, p));

	}

	public int getShortestPathBetweenTwoNodes(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode ancestor = FindTheAncestor(root, p, q);
		return PathBetweenRootToNode(root, p) + PathBetweenRootToNode(root, q);
	}

}
