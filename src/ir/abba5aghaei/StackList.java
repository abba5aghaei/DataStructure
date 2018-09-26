package ir.abba5aghaei;

public class StackList {
	
	static StackNode top;
	
	public void push(Object item) {
		
		top = new StackNode(item, top);
	}
	public Object peek() {
		
		return top.info;
	}
	public Object pop() {
		
		StackNode oldTop = new StackNode();
		oldTop = top;
		Object item = peek();
		top = top.link;
		oldTop.link = null;
		return item;
	}
	public boolean isEmpty() {
		
		return (top == null);
	}
}
