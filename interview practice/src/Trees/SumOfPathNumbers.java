package Trees;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
};

class SumOfPathNumbers {
	public static int findSumOfPathNumbers(TreeNode root) {
		ArrayList<Integer> al = new ArrayList<>();
		findSumOfPathNumbersHelper(root, 0, al);

		int s = al.stream().reduce(0, (a, b) -> a + b);
		return s;
	}

	public static void findSumOfPathNumbersHelper(TreeNode root, int sum, List<Integer> result) {
		if (root != null) {
			sum = sum * 10 + root.val;

			if (root.right == null && root.left == null)
				result.add(sum);

			findSumOfPathNumbersHelper(root.left, sum, result);
			findSumOfPathNumbersHelper(root.right, sum, result);
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);
		System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
	}
}
