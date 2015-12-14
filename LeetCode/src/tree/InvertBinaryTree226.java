package tree;

public class InvertBinaryTree226 {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode temp = root.right;
		root.right = root.left;
		root.left = temp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
}
