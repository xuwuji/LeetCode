package tree.medium;

import tree.easy.TreeNode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes v and w as the lowest node in T that has both v
 * and w as descendants (where we allow a node to be a descendant of itself).”
 * 
 * 
 * 
 * @author xuwuji
 *
 */
public class LowestCommonAncestorofaBinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null) {
			return null;
		}

		if (p == root) {
			return p;
		}

		if (q == root) {
			return q;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left == null && right == null)
			return null;
		// means p and q is under the left tree of the root node
		if (left != null && right == null)
			return left;
		// means p and q is under the right tree of the root node
		if (left == null && right != null)
			return right;
		// means p and q is under the different side of the root node,so it can
		// not just write if(left!=null) return left, because when p and q are
		// in different side of the tree, both the left and right have value
		return root;
	}

}
