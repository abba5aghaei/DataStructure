package ir.abba5aghaei;

public class BinarySearchTree {
	
	TreeNode root;
	
	public boolean insert(Object item) {
		
		if(isEmpty()) {
			
			root = new TreeNode(item);
			return true;
		}
		else return root.insertNode(item);
	}
	public boolean isEmpty() {
		
		return (root == null);
	}
	public boolean search(Object target) {
		
		return search(root, target);
	}
	private boolean search(TreeNode root, Object target) {
		
		if(isEmpty())
			return false;
		
		else {
			
			if(target.toString().compareTo(root.info.toString()) == 0)
				return true;
				
			else if(target.toString().compareTo(root.info.toString()) < 0)	
				if(root.left == null)
					return false;
				
				else
					return search(root.left, target);
			
			else
				if(root.right == null)
					return false;
				else
					return search(root.right, target);
		}
	}
	public void display() {
		
		Main.treeObject.removeAllElements();
		
		display(root);
	}
	private void display(TreeNode root) {
		
		if(!isEmpty())
		{
			if(root.left != null)
				display(root.left);
				
				
			Main.treeObject.addElement((root.info).toString());
			//System.out.println((root.info).toString());
			
			if(root.right != null)
				display(root.right);
		}
	}
	public boolean remove(Object target) {
		
		if(Main.treeObject.contains(target)) {
			
			Main.treeObject.removeElementAt(Main.treeObject.indexOf(target));
			
			root = null;
			
			for(int i=0 ; i<Main.treeObject.size() ; i++)
				insert(Main.treeObject.elementAt(i));
			
			return true;
		}
		else
			return false;
	}
}