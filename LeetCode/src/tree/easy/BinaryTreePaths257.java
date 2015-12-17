package tree.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257 {
	public List<String> binaryTreePaths(TreeNode root) {

		List<String> list = new ArrayList<String>();
		if (root == null) {
			return list;
		}
		StringBuilder sb = new StringBuilder();
		helper(list, "", root);
		return list;
	}

	public void helper(List<String> list, String string, TreeNode pointer) {
		if (pointer == null) {
			return;
		}

		if (pointer.left == null && pointer.right == null) {
			string = string + pointer.val;
			list.add(string);
		} else {
			string += pointer.val + "->";

			if (pointer.left != null) {

				helper(list, string, pointer.left);
			}

			if (pointer.right != null) {
				helper(list, string, pointer.right);
			}

		}
	}
}
