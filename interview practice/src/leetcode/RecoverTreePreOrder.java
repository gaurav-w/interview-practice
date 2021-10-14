package leetcode;


import java.util.HashMap;
import java.util.Map;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class RecoverTreePreOrder {

    public static void main(String[] args) {
        RecoverTreePreOrder r = new RecoverTreePreOrder();
        r.recoverFromPreorder("1-2--3---4-5--6---7");
    }

    public TreeNode recoverFromPreorder(String S) {
        Map<Integer, TreeNode> levels = new HashMap<>();
        int i = 0;
        while (i < S.length()) {
            int curLevel = 0, curNum = 0;
            while (i < S.length() && S.charAt(i) == '-') {
                ++curLevel;
                ++i;
            }
            while (i < S.length() && S.charAt(i) >= '0' && S.charAt(i) <= '9') {
                curNum = curNum * 10 + (S.charAt(i) - '0');
                i++;
            }
            TreeNode curNode = new TreeNode(curNum);
            levels.put(curLevel, curNode);
            if (curLevel > 0) {
                TreeNode parent = levels.get(curLevel - 1);
                if (parent.left == null) parent.left = curNode;
                else parent.right = curNode;
            }
        }
        return levels.get(0);
    }
}
