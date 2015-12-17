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
		if (under(root.left, p) == Boolean.FALSE && under(root.left, q) == Boolean.FALSE) {
			return lowestCommonAncestor(root.right, p, q);
		} else if (under(root.left, p) == Boolean.TRUE && under(root.left, q) == Boolean.TRUE) {
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return root;
		}
	}

	public boolean under(TreeNode pointer, TreeNode checkNode) {
		if (pointer == null) {
			return false;
		}

		if (pointer.val == checkNode.val) {
			return true;
		} else {
			return under(pointer.left, checkNode) || under(pointer.right, checkNode);
		}
	}
}
