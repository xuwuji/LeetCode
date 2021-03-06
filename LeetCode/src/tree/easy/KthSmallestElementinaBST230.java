package tree.easy;

import java.util.Stack;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth
 * smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 �?k �?BST's total elements.
 * 
 * Follow up: What if the BST is modified (insert/delete operations) often and
 * you need to find the kth smallest frequently? How would you optimize the
 * kthSmallest routine?
 * 
 * 
 * @author xuwuji
 *
 */
public class KthSmallestElementinaBST230 {
	public int kthSmallest(TreeNode pointer, int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int count = 0;
		while (pointer != null || !stack.isEmpty()) {
			while (pointer != null) {
				stack.push(pointer);
				pointer = pointer.left;
			}

			if (!stack.isEmpty()) {
				TreeNode node = stack.peek();
				pointer = node.right;
				count++;
				if (k == count) {
					return stack.pop().val;
				}

				stack.pop();

			}
		}

		return 0;

	}

	public int kthSmallestRecursive(TreeNode pointer, int k) {
		int number = getNodesCount(pointer.left);

		if (k == number + 1) {
			return pointer.val;
		} else if (k < number + 1) {
			return kthSmallest(pointer.left, k);
		} else {
			return kthSmallest(pointer.right, k - number - 1);
		}

	}

	private int getNodesCount(TreeNode pointer) {
		if (pointer == null)
			return 0;
		return 1 + getNodesCount(pointer.left) + getNodesCount(pointer.right);
	}
}
