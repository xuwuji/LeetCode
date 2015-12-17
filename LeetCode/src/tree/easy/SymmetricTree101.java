package tree.easy;

public class SymmetricTree101 {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		if (isSymmetrichelper(root.right, root.left)) {
			return true;
		}
		return false;
	}

	public boolean isSymmetrichelper(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}

		if (p == null || q == null) {
			return false;
		}

		if (p.val == q.val && isSymmetrichelper(p.left, q.right) && isSymmetrichelper(p.right, q.left)) {
			return true;
		}
		return false;
	}
	
	

}
