package tree.medium;

import tree.easy.TreeNode;

public class test {
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (under(root.left, p) == Boolean.FALSE && under(root.left, q) == Boolean.FALSE) {
			return lowestCommonAncestor(root.right, p, q);
		} else if (under(root.left, p) == Boolean.TRUE && under(root.left, q) == Boolean.TRUE) {
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return root;
		}
	}

	public static boolean under(TreeNode pointer, TreeNode checkNode) {
		if (pointer == null) {
			return false;
		}

		if (pointer.val == checkNode.val) {
			return true;
		} else {
			return under(pointer.left, checkNode) || under(pointer.right, checkNode);
		}
	}

	public static void main(String[] args) {
		if (false ^ true) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

		System.out.println(under(null, null));
	}

}
