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

class FindAllTreePaths {
	public static List<List<Integer>> findPaths(TreeNode root, int sum) {
		List<List<Integer>> allPaths = new ArrayList<>();
		List<Integer> currentPath = new ArrayList<Integer>();
		findPathsHelper(root, sum, currentPath, allPaths);
		return allPaths;
	}

	public static void findPathsHelper(TreeNode root, int sum, List<Integer> currentPath,
			List<List<Integer>> allPaths) {

		if (root == null)
			return;

		currentPath.add(root.val);

		if (root.val == sum && root.left == null && root.right == null) {
			allPaths.add(new ArrayList<Integer>(currentPath));
		}
		
		findPathsHelper(root.left, sum - root.val, currentPath, allPaths);
		findPathsHelper(root.right, sum - root.val, currentPath, allPaths);
		

		currentPath.remove(currentPath.size() - 1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		int sum = 23;
		List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
		System.out.println("Tree paths with sum " + sum + ": " + result);
	}
}
