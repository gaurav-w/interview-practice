package Trees;

import java.util.ArrayList;

class InorderSuccessor {
	static BinaryTreeNode findMin(BinaryTreeNode root) {
		if (root == null)
			return null;

		while (root.left != null) {
			root = root.left;
		}

		return root;
	}

	static BinaryTreeNode inorderSuccessorBST(BinaryTreeNode root, int d) {
		BinaryTreeNode parent = null;
		BinaryTreeNode grandParent = null;

		while (root != null) {

			if (root.data == d) {
				if (root.left == null && root.right == null) {
					if (parent.left == root) {
						return parent;
					} else {
						return grandParent;
					}
				} else {
					if (root.right != null) {

						BinaryTreeNode succ = root.right;
						while (succ != null) {
							succ = succ.left;
						}
						return succ;
					} else
						return parent;
				}
			} else if (root.data > d) {
				grandParent = parent;
				parent = root;
				root = root.left;
			} else {
				parent = root;
				root = root.right;
			}

		}

		return null;
	}

	/// Test Program.
	public static void main(String[] args) {
		ArrayList<Integer> origData = new ArrayList<Integer>();
		origData.add(100);
		origData.add(50);
		origData.add(200);
		origData.add(25);
		origData.add(75);
		origData.add(125);
		origData.add(350);
		BinaryTreeNode root = BinaryTree.createBST(origData);

		ArrayList<Integer> allData = BinaryTree.BSTtoArraylist(root);

		for (Integer d : origData) {
			BinaryTreeNode successor = inorderSuccessorBST(root, d);
			int i = allData.indexOf(d);
			Integer expectedVal = null;
			if (i < allData.size() - 1) {
				expectedVal = allData.get(i + 1);
			}

			if (successor != null) {
				if (expectedVal.intValue() != successor.data) {
					System.out.println("*******" + d + " ==== " + expectedVal + ", " + successor.data + "*****");
					// System.out.println(expectedVal.intValue() == successor.data);
				}
			} else {
				// System.out.println(successor == null);
			}
			if (successor != null) {
				System.out.print("(" + d + ", " + successor.data + ") ");
			} else {
				System.out.print("(" + d + ", null) ");
			}
		}
	}
}