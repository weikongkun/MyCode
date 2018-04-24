package JianZhiOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Eg25_PathInTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return res;
        int sum = 0;
        Stack<Integer> s= new Stack<>();
        FindPath(res, s, root, sum, target);
        return res;
        
    }
	
	public static void FindPath(ArrayList<ArrayList<Integer>> res, Stack<Integer> s, TreeNode root, int currentSum, int target) {
		currentSum += root.val;
		s.push(root.val);
		if (root.left == null && root.right == null && currentSum == target) {
			ArrayList<Integer> subList = new ArrayList<Integer>();
			subList.addAll(s);
			res.add(subList);
		}
		if (root.left != null)
			FindPath(res, s, root.left, currentSum, target);
		if (root.right != null)
			FindPath(res, s, root.right, currentSum, target);
		s.pop();
	}

}
