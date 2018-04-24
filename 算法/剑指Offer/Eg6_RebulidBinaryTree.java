package JianZhiOffer;

public class Eg6_RebulidBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static TreeNode rebuildBinaryTree(int[] pre, int[] in) {
		if (pre == null || in == null)
			return null;
		
		return rebuildBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
						
	}
	
	public static TreeNode rebuildBinaryTree(int[] pre, int[] in, int startPre, int endPre, int startIn,
			int endIn) {
		
		if (startPre > endPre || startIn > endIn)
			return null;
		int rootVal = pre[startPre];
		TreeNode root = new TreeNode(rootVal);
		int rootIndex = 0;
		for (int i = startIn; i <= endIn; i++)
			if (rootVal == in[i]) {
				rootIndex = i;
				break;
			}
		int lenOfLeft = rootIndex - startIn;
		root.left = rebuildBinaryTree(pre, in, startPre + 1, startPre + lenOfLeft, startIn, rootIndex - 1);
		root.right = rebuildBinaryTree(pre, in, startPre + lenOfLeft + 1, endPre, rootIndex + 1, endIn);
		return root;
	}
	

}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int val) {
		this.val = val;
	}
}
