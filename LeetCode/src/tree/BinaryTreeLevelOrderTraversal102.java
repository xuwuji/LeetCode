package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal102 {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		helper(list, root, 0);
		return list;
	}

	public void helper(List<List<Integer>> list, TreeNode pointer, int level) {
		if (pointer == null) {
			return;
		}
		if (list.size() == level) {
			list.add(new ArrayList<Integer>());
		}
		list.get(level).add(pointer.val);
		helper(list, pointer.left, level + 1);
		helper(list, pointer.right, level + 1);
	}
}
