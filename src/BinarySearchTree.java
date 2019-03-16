import java.util.*;
import java.util.LinkedList;

/**
 * Created by rbhoompally on 1/18/18.
 */
public class BinarySearchTree {
    public TreeNode minimalHeightBST(int[] a) {
        return minimalHeightBST(a, 0, a.length - 1);
    }

    private TreeNode minimalHeightBST(int[] a, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(a[mid]);
        root.left = minimalHeightBST(a, left, mid - 1);
        root.right = minimalHeightBST(a, mid + 1, right);
        return root;
    }

    public void printBst(TreeNode root) {
        int height = getHeight(root);
        int totalCols = (int) Math.pow(2, height);
        ArrayList<ArrayList<TreeNode>> levelNodes = getLevelwiseNodes(root);

        for (int i = 0; i < levelNodes.size(); i++) {
            ArrayList<TreeNode> level = levelNodes.get(i);

            for (TreeNode node: level) {
                System.out.print(node.value + "\t");
            }
            System.out.println();
        }
    }

    public int getHeight(TreeNode root) {
        return getHeight(root, 0);
    }

    private int getHeight(TreeNode node, int height) {
        if (node == null) {
            return height + 1;
        }

        int leftHeight = getHeight(node.left, height + 1);
        int rightHeight = getHeight(node.right, height + 1);
        return Math.max(leftHeight, rightHeight);
    }

    public ArrayList<ArrayList<TreeNode>> getLevelwiseNodes(TreeNode root) {
        if (root == null) {
            return null;
        }

        ArrayList<ArrayList<TreeNode>> allLevels = new ArrayList<>();
        ArrayList<TreeNode> worker = new ArrayList<>();
        worker.add(root);
        allLevels.add(worker);

        while (!worker.isEmpty()) {
            ArrayList<TreeNode> children = new ArrayList<>();

            for (TreeNode node: worker) {
                if (node.left != null) {
                    children.add(node.left);
                }

                if (node.right != null) {
                    children.add(node.right);
                }
            }

            if (!children.isEmpty()) {
                allLevels.add(children);
            }
            worker = children;
        }

        return allLevels;
    }
}
