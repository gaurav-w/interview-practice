package DFS;

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

		findPathsHelper(root, sum, allPaths, new ArrayList());
		return allPaths;
	}

	public static void findPathsHelper(TreeNode root, int sum, List<List<Integer>> allPaths, List<Integer> path) {

		if (root == null)
			return;
		
		path.add( root.val);

		if (sum == root.val && root.left == null && root.right == null)
			allPaths.add(new ArrayList(path));
		else {
			findPathsHelper(root.left, sum - root.val, allPaths, path );
			findPathsHelper(root.right, sum - root.val, allPaths, path);
		}
		//backtrack
		path.remove(path.size() - 1);
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
