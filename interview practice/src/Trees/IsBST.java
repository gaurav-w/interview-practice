package Trees;

class IsBST {
	public static boolean isBst(BinaryTreeNode root) {

		return isBstHelper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

	public static boolean isBstHelper(BinaryTreeNode root, int min, int max) {
		if (root == null)
			return true;

		if (root.left != null) {
			if (root.data < root.left.data || root.left.data > min)
				return false;
			min = Math.min(min, root.left.data);
		}

		if (root.right != null) {
			if (root.data > root.right.data || root.right.data < max)
				return false;
			max = Math.max(max, root.right.data);
		}

		return isBstHelper(root.left, min, max) && isBstHelper(root.right, min, max);
	}
	
	public static void main(String[] argv) {
	    BinaryTreeNode root = new BinaryTreeNode(100);
	    BinaryTree.insert(root, 50);
	    BinaryTree.insert(root, 200);
	    BinaryTree.insert(root, 25);
	    // Add a node at an incorrect position
	    BinaryTree.insertInorderBinaryTree(root, 125);
	    BinaryTree.insert(root, 150);
	    BinaryTree.insert(root, 300);
	    
	    BinaryTree.displayInorder(root);
	    System.out.println();
	    System.out.println(Boolean.toString(isBst(root)));
	  }
}