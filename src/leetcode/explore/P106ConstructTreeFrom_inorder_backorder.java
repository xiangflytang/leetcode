package leetcode.explore;

import java.util.HashMap;
import java.util.Map;

public class P106ConstructTreeFrom_inorder_backorder {
//    根据中序遍历和后续遍历的特性我们进行树的还原过程分析
//
//    首先在后序遍历序列中找到根节点(最后一个元素)
//    根据根节点在中序遍历序列中找到根节点的位置
//    根据根节点的位置将中序遍历序列分为左子树和右子树
//    根据根节点的位置确定左子树和右子树在中序数组和后续数组中的左右边界位置
//    递归构造左子树和右子树
//    返回根节点结束

//    作者：reals
//    链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/tu-jie-gou-zao-er-cha-shu-wei-wan-dai-xu-by-user72/

    Map<Integer, Integer> inorderMap = new HashMap<>();
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        post = postorder;
        TreeNode root= buildTree(0, inorder.length - 1, 0, postorder.length - 1);
        return root;
    }

    public TreeNode buildTree(int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
        if ((inorderEnd <inorderStart) || ( postorderEnd<postorderStart)) {
            return null;
        }
        int inorderIndex = inorderMap.get(post[postorderEnd]);
        TreeNode node = new TreeNode(post[postorderEnd]);
        node.left = buildTree(inorderStart, inorderIndex - 1, postorderStart, postorderStart + inorderIndex - inorderStart - 1);
        node.right = buildTree(inorderIndex+1, inorderEnd, postorderStart + inorderIndex - inorderStart, postorderEnd-1);
        return node;
    }

    public static void main(String[] args) {

    }
}
