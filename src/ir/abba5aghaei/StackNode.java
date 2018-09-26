package ir.abba5aghaei;
public class StackNode {
	
	Object info;
	StackNode link;
	
	StackNode() {}
	
	StackNode(Object ob) {
		
		info = ob;
	}
	StackNode(Object ob, StackNode lnk) {
		
		info = ob;
		link = lnk;
	}
}
