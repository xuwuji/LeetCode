package tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tree.TreeNode;

public class BinaryTreeInorderTraversal94 {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		helper(list, root);
		return list;

	}

	public void helper(List<Integer> list, TreeNode pointer) {
		if (pointer != null) {
			helper(list, pointer.left);
			list.add(pointer.val);
			helper(list, pointer.right);
		}
	}

	public List<Integer> inorderTraversalWithoutRecursive(TreeNode pointer) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		while (pointer != null || !stack.isEmpty()) {

			while (pointer != null) {
				stack.push(pointer);
				pointer = pointer.left;
			}
			
			list.add(stack.peek().val);

			pointer = stack.pop().right;

		}
		return list;
	}
}
