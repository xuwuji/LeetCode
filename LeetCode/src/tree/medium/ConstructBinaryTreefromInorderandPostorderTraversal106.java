package tree.medium;

import tree.easy.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal106 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {

		if (inorder.length == 0 || postorder.length == 0) {
			return null;
		}

		int length = postorder.length;
		TreeNode root = new TreeNode(postorder[length - 1]);
		root.left = null;
		root.right = null;

		int position = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == postorder[length - 1]) {
				position = i;
				break;
			}
		}

		int[] left_post = new int[position];
		int[] left_in = new int[position];
		int[] right_post = new int[length - position - 1];
		int[] right_in = new int[length - position - 1];

		int j = 0;

		for (int i = 0; i < length - 1; i++) {
			if (i < position) {
				left_post[i] = postorder[i];
				left_in[i] = inorder[i];
			} else if (i >= position) {
				right_post[j] = postorder[i];
				right_in[j] = inorder[i + 1];
				j++;
			}

		}

		root.left = buildTree(left_in, left_post);
		root.right = buildTree(right_in, right_post);

		return root;
	}
}
