package trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by da.teng on 3/3/17.
 */
public class SerializeDeserialize {

    private String spliter = ",";
    private String nullNode = "X";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
           sb.append(nullNode);
            sb.append(spliter);
        } else {
            sb.append(node.getData()).append(spliter);
            buildString(node.getLeft(), sb);
            buildString(node.getRight(), sb);
        }
    }

    public TreeNode deserialise(String str) {
        Queue<String> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.addAll(Arrays.asList(str.split(spliter)));
        return buildTree(treeNodeQueue);
    }

    private TreeNode buildTree(Queue<String> treeNodeQueue) {
        String val = treeNodeQueue.remove();
        if (val.equals(nullNode)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.getInteger(val));
        node.setLeft(buildTree(treeNodeQueue));
        node.setRight(buildTree(treeNodeQueue));
        return node;
    }
}
