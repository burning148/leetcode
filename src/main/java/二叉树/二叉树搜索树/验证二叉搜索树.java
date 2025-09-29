package 二叉树.二叉树搜索树;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 验证二叉搜索树 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;

        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }


    /**
     * 中序遍历用容器记录
     */
    private List<Integer> list = new ArrayList<>();
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        dfs(root);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
