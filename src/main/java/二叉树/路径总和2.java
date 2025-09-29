package 二叉树;

import java.util.ArrayList;
import java.util.List;

public class 路径总和2 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.add(root.val); // 先将当前节点添加到路径中
        if (root.left == null && root.right == null && targetSum == root.val) { // 再判断是否到达叶子节点且路径和等于目标和
            res.add(new ArrayList<>(path));
        }

        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
        path.remove(path.size() - 1); // 回溯
    }

//    public static void main(String[] args) {
//        TreeNode root = buildTree(new int[]{5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, 5, 1});
//        System.out.println(pathSum(root, 22));
//    }


    public static TreeNode buildTree(int[] arr) {
        return buildTree(arr, 0);
    }

    private static TreeNode buildTree(int[] arr, int index) {
        if (index >= arr.length || arr[index] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(arr[index]);
        root.left = buildTree(arr, 2 * index + 1);
        root.right = buildTree(arr, 2 * index + 1);
        return root;
    }

}
