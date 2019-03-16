import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by rbhoompally on 2/26/18.
 */
public class LevelwiseNodes {
    public ArrayList<LinkedList<TreeNode>> nodesAtDepth(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayList<LinkedList<TreeNode>> all = new ArrayList<>();
        LinkedList<TreeNode> level = new LinkedList<>();
        level.add(root);
        all.add(new LinkedList<>(level));


        LinkedList<TreeNode> newLevel = new LinkedList<>();
        while (!level.isEmpty()) {
            TreeNode probe = level.removeFirst();
            if (probe.left != null) {
                newLevel.add(probe.left);
            }

            if (probe.right != null) {
                newLevel.add(probe.right);
            }

            if(level.isEmpty()) {
                if (!newLevel.isEmpty()) {
                    all.add(new LinkedList<>(newLevel));
                }
                level = newLevel;
                newLevel = new LinkedList<>();
            }
        }

        return all;
    }
}
