package interview.leetcode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

	/**
	 * Given preorder and inorder traversal of a tree, construct the binary tree.
		
		Note:
		You may assume that duplicates do not exist in the tree.
	 */
	
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        int inStart = 0;
        int inEnd = inorder.length-1;
        int preStart =0;
        int preEnd = inorder.length-1;
 
        return buildTree(inorder, inStart, inEnd, preorder, preStart, preEnd);
    }
 
    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, 
                            int[] preorder, int preStart, int preEnd){
        if(inStart > inEnd || preStart > preEnd)
            return null;
 
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);
 
        int k=0;
        for(int i=0; i< inorder.length; i++){
            if(inorder[i]==rootValue){
                k = i;
                break;
            }
        }
        int size_l_subtree=k-inStart;
        root.left = buildTree(inorder, inStart, k-1, preorder, preStart+1, preStart + size_l_subtree);
        root.right = buildTree(inorder, k+1, inEnd, preorder, preStart + size_l_subtree +1, preEnd);
 
        return root;
    }
}
