package tree;

public class ValidateBinarySearchTree98 {
	public boolean isValidBST(TreeNode root) {
		return isBSTHelper(root, null, null);
	}

	private boolean isBSTHelper(TreeNode root, Integer low, Integer high) {
		if (root == null) {
			return true;
		}

		if ((low == null || root.val > low) && (high == null || root.val < high)
				&& isBSTHelper(root.left, null, root.val) && isBSTHelper(root.right, root.val, high)) {
			return true;
		}

		return false;
	}
}
