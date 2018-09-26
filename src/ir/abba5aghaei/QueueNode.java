package ir.abba5aghaei;
public class QueueNode {
	
	Object info;
	QueueNode link;
	
	QueueNode() {}
	
	QueueNode(Object ob) {
		
		info = ob;
		link = null;
	}
	QueueNode(Object ob, QueueNode lnk) {
		
		info = ob;
		link = lnk;
	}
}
