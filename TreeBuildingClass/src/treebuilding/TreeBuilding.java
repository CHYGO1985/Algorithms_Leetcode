package treebuilding;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Method buildTreeFromArray(): build a tree from an array of int data.
 * -1 means leaf node.
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 9, 2017
 */
public class TreeBuilding {
	
	public static class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void buildTreeFromArray(TreeNode root, int[] nums) {
		
		if (null == nums || 0 == nums.length) return ;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		int index = 1;
		
		while (index < nums.length - 1 && queue.isEmpty() == false) {
			
			TreeNode tmp = queue.poll();
			tmp.left = new TreeNode(nums[index ++]);
			if (tmp.left.val != -1) queue.add(tmp.left);
			tmp.right = new TreeNode(nums[index ++]);
			if (tmp.right.val != -1) queue.add(tmp.right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,-1,-1,4,-1,-1,-1};
		TreeNode root = new TreeNode(nums[0]);
		buildTreeFromArray(root, nums);
	}

}
