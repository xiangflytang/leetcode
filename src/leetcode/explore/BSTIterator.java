package leetcode.explore;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
	// 用list 把inorder的遍历存起来，这就是 BST从小到大的排序结果。
	TreeNode root;
	List<Integer> bst = new ArrayList<>();
	int current=0;

	public BSTIterator(TreeNode root) {
		this.root = root;
		inOrderTranverse(root);
	}

	void inOrderTranverse(TreeNode root) {
		if (root != null) {
			inOrderTranverse(root.left);
			bst.add(root.val);
			inOrderTranverse(root.right);
		}
	}

	/** @return the next smallest number */
	public int next() {
		int val =bst.get(current);
		current++;
		return val;
	}


	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return current<bst.size()?true:false;
	}

}
