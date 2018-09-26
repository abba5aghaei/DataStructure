package ir.abba5aghaei;
public class TreeNode {
	
	Object info;
	TreeNode right;
	TreeNode left;
	
	TreeNode() {}
	
	TreeNode(Object ob) {
		
		info = ob;
		right = null;
		left = null;
	}
	public boolean insertNode(Object item) {
		
		if(item.toString().compareTo(info.toString()) == 0)
			return false;
		
		else if(item.toString().compareTo(info.toString()) < 0)
			
			if(left == null) {
				
				left = new TreeNode(item);
				return true;
			}
			else
				return left.insertNode(item);
		else {
			
			if(right == null) {
				
				right = new TreeNode(item);
				return true;
			}
			else 
				return right.insertNode(item);
		}
	}
}
