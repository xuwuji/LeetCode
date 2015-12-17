package tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.easy.TreeNode;

public class BinaryTreePreorderTraversal144 {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		helper(list, root);
		return list;
	}

	public void helper(List<Integer> list, TreeNode pointer) {
		if (pointer != null) {
			list.add(pointer.val);
			helper(list, pointer.left);
			helper(list, pointer.right);
		}
	}

	public List<Integer> preorderTraversalWithOutRecurisive(TreeNode pointer) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (pointer != null || !stack.isEmpty()) {

			while (pointer != null) {
				list.add(pointer.val);
				stack.push(pointer);
				pointer = pointer.left;
			}

			if (!stack.isEmpty()) {
				pointer = stack.pop().right;
			}
		}
		return list;
	}
}
