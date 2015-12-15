package tree;

public class BalancedBinaryTree110 {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		int diff = Depth(root.left) - Depth(root.right);
		if (diff < 2 && diff > -2 && isBalanced(root.left) && isBalanced(root.right)) {
			return true;
		}
		return false;
	}

	public int Depth(TreeNode pointer) {
		if (pointer == null) {
			return 0;
		}
		return 1 + Math.max(Depth(pointer.left), Depth(pointer.right));

	}
}
