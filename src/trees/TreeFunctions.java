package trees;

import java.util.Stack;

/**
 * Created by da.teng on 2/16/17.
 */
public class TreeFunctions {

    public static void dfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        visit(root);
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (isLeavesVisited(node)) {
                stack.pop();
            } else {
                if (isAddingLeafToStack(node.getLeft())) {
                    visit(node.getLeft());
                    stack.add(node.getLeft());
                } else if (isAddingLeafToStack(node.getRight())) {
                    visit(node.getRight());
                    stack.add(node.getRight());
                }
            }
        }
    }

    private static boolean isAddingLeafToStack(TreeNode node) {
        if (node != null && !node.isVisited()) {
            return true;
        }
        return false;
    }

    private static void visit(TreeNode node) {
        node.setVisited(true);
        System.out.print(node.getData());
    }

    private static boolean isLeavesVisited(TreeNode node) {
        if ( (node.getRight() == null || node.getRight().isVisited())
                && (node.getLeft() == null || node.getLeft().isVisited()) ) {
            return true;
        }
        return false;
    }

    public static void main (String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.setRight(node2);
        node1.setLeft(node3);
        node2.setRight(node4);
        node2.setLeft(node5);
        node3.setRight(node6);
        node3.setLeft(node7);

        dfs(node1);
    }
}
