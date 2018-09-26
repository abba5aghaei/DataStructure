package ir.abba5aghaei;
public class ListNode {
	
	String data;
	ListNode Rlink;
	ListNode Llink;
	
	ListNode() {
		
		data = "";
		
		Rlink = null;
		
		Llink = null;
	}
	ListNode(String s) {
		
		data = s;
		
		Rlink = null;
		
		Llink = null;
	}
	ListNode(String s, ListNode r, ListNode l) {
		
		data = s;
		
		Rlink = r;
		
		Llink = l;
	}
}
