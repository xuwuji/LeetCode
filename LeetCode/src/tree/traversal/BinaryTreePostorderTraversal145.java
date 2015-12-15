package tree.traversal;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

public class BinaryTreePostorderTraversal145 {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		helper(list, root);
		return list;
	}

	public void helper(List<Integer> list, TreeNode pointer) {
		if (pointer != null) {

			helper(list, pointer.left);
			helper(list, pointer.right);
			list.add(pointer.val);
		}
	}
}
