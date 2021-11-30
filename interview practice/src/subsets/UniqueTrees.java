package subsets;

import java.util.*;

//1 2 3
//1 3 2
//2 3 1 - no
//2 1 3
//3 2 1
//3 1 2

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
};

class UniqueTrees {
	public static List<TreeNode> findUniqueTrees(int n) {
		List<TreeNode> result = new ArrayList<>();

		// generate all subsets
		// make BST and string
		// if string is in Set dont add it

		List<List<Integer>> subsets = new ArrayList<>();
		List<List<Integer>> completeSets = new ArrayList<>();
		HashSet<String> set = new HashSet<String>();

		subsets.add(new ArrayList<Integer>());

		for (int i = 0; i < n; i++) { // num
			int m = subsets.size();
			for (int j = 0; j < m; j++) { // subset no

				List<Integer> currentSet = subsets.get(j);

				int p = currentSet.size();
				for (int pos = 0; pos <= p; pos++) {
					List<Integer> newSet = new ArrayList<>(currentSet);
					newSet.add(pos, i + 1);

					if (newSet.size() == n) {
						completeSets.add(newSet);
						System.out.println(newSet);
					} else
						subsets.add(newSet);

				}

			}
		}

		// make BST of completesets
		for (int i = 0; i < completeSets.size(); i++) {
			TreeNode node = new TreeNode(completeSets.get(i).get(0));
			StringBuffer sb = new StringBuffer();
			sb.append("H");
			makeBST(completeSets.get(i), sb, 1, node);

			if (!set.contains(sb.toString())) {
				System.out.println(sb.toString());
				set.add(sb.toString());
				result.add(node);
			}

		}

		return result;
	}

	private static void makeBST(List<Integer> completeSet, StringBuffer sb, int index, TreeNode head) {

		if (completeSet.size() <= index)
			return;

		int currentVal = completeSet.get(index);

		if (head == null)
			head = new TreeNode(currentVal);
		else if (head.val > currentVal) {
			head.left = new TreeNode(currentVal);
			sb.append("L");
			makeBST(completeSet, sb, index + 1, head.left);
		} else {
			head.right = new TreeNode(currentVal);
			sb.append("R");
			makeBST(completeSet, sb, index + 1, head.right);
		}

	}

	public static void main(String[] args) {
		List<TreeNode> result = UniqueTrees.findUniqueTrees(3);
		System.out.print("Total trees: " + result.size());
	}
}
