package tree.medium;

import tree.easy.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * @author wuxu
 *
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {

		if (preorder.length == 0 || inorder.length == 0) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[0]);
		root.left = null;
		root.right = null;

		// get the position of the root node (first node in the pre-order)
		int position = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == preorder[0]) {
				position = i;
				break;
			}
		}

		int[] left_pre = new int[position];
		int[] left_in = new int[position];
		int[] right_pre = new int[preorder.length - position - 1];
		int[] right_in = new int[preorder.length - position - 1];

		// get the left sub tree
		int i = 0;
		while (i < position) {
			left_pre[i] = preorder[i + 1];
			left_in[i] = inorder[i];
			i++;
		}
		root.left = buildTree(left_pre, left_in);

		// get the right sub tree
		i = position + 1;
		int j = 0;
		while (i < preorder.length) {
			right_pre[j] = preorder[i];
			right_in[j] = inorder[i];
			i++;
			j++;
		}
		root.right = buildTree(right_pre, right_in);

		return root;
	}
}
