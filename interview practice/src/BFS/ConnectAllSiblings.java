package BFS;

import java.util.*;



class ConnectAllSiblings {
  public static void connect(TreeNode root) {
    
  TreeNode currNode = null;
  TreeNode prevNode = null;
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.offer(root);

    while( !q.isEmpty() ){
      int levelSize = q.size();

      for(int i=0; i<levelSize; i++){
          currNode =   q.remove();

          if( currNode.left!=null)
            q.offer(currNode.left);

          if( currNode.right!=null)
            q.offer(currNode.right);

          if(prevNode!=null) {
            prevNode.next = currNode;
          }

          prevNode = currNode;

      }
    }

  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    ConnectAllSiblings.connect(root);

    // level order traversal using 'next' pointer
    TreeNode current = root;
    System.out.println("Traversal using 'next' pointer: ");
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
  }
}