package tree.traversal;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

public class BinaryTreeLevelOrderTraversalII107 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int level = maxDepth(root);
		for (int i = 0; i < level; i++) {
			list.add(new ArrayList<Integer>());
		}
		helper(list, root, 0);
		return list;

	}

	public void helper(List<List<Integer>> list, TreeNode pointer, int level) {
		if (pointer == null) {
			return;
		}

		list.get(list.size() - level - 1).add(pointer.val);
		helper(list, pointer.left, level + 1);
		helper(list, pointer.right, level + 1);
	}

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));

	}
}
