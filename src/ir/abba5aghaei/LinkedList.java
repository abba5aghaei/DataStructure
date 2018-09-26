package ir.abba5aghaei;
//import java.util.Scanner;

public class LinkedList {
	
	//static Scanner input = new Scanner(System.in);
	 ListNode head, last;
	 String result = "", status = "";
	 boolean flag = true;

	/*public static void main(String[] args) {
		
		while(true) {
		System.out.print("Select a job:\n1.Traverse\n2.Add Node\n3.Remove");
		
		int j = input.nextInt();
		
		switch(j) {
		
		case 1: Traverse(head); break;
		
		case 2: AddNode(); break;
		
		case 3: System.out.print("Enter Node data: "); RemoveNode(input.next(), head); break;
		
		default: System.out.print("\nEror: Wrong selection!");
		}
		System.out.print("\nDo you want to continue?(1/0): ");
		
		int c = input.nextInt();
		
		if(c == 0)
			break;
		}
	}*/
	public void Traverse(ListNode next) {
		
		if(next != null) {
			if(next == head)
				result += "[" + next.data + "]";
			else
		//System.out.println(next.data);
			result += " <---> [" + next.data + "]";
		
		    Traverse(next.Rlink);
		}
	}
	public LinkedList() {
		
		head = new ListNode();
		
		head = null;
		
	    last = new ListNode();
	}
	public void RemoveNode(String s, ListNode next) {
		
		if(next != null) {
			
			if(next.data.equalsIgnoreCase(s)) {
				if(next == head) {
					
					head = next.Rlink;
					
					next.Rlink = null;
					
					//System.out.print(s + " is removed from list");
				}
				else if(next == last) {
					
					last = next.Llink;
					
					last.Rlink = null;
					
					next.Llink = null;
					
					//System.out.print(s + " is removed from list");
				}
				else {
					
					next.Llink.Rlink = next.Rlink;
					
					next.Rlink.Llink = next.Llink;
					
					next.Rlink = null;
					
					next.Llink = null;
					
					//System.out.print(s + " is removed from list");
				}
				status = s +" is removed from list.";
				flag = true;
			}
			else {
				
				RemoveNode(s, next.Rlink);
			}
		}
		else {
			status = s +" is not found!";
			flag = false; }
		    //System.out.print(next.data + " is not found");	
	}
	public void AddNode(String newData, String in, ListNode next) {
		
		/*System.out.print("Enter node data: ");
		
		String newData = new String();
		
		newData = input.next();
		
		while(!(newData.trim().equals("stop"))) {*/
		if(in.equalsIgnoreCase("End"))
		   {
			ListNode node = new ListNode();
			
			node.data = newData;
			
			node.Rlink = null;
			
			node.Llink = null;
			
			if(head == null) {
				
				head = node;;
				
				last = node;
				
				status = newData +" inserted to list.";
				flag = true;
			}
			else {
				last.Rlink = node;
				
				node.Llink = last;
				
				last = node;
				
				status = newData +" inserted to list.";
				
				flag = true;
			 }
		    }
		    else {
		    	if(next != null) {
					
					if(next.data.equalsIgnoreCase(in)) {
						
						ListNode node = new ListNode();
						
						node.data = newData;
						
						if(next == head) {
							
							node.Llink = null;
							
							node.Rlink = head;
							
							head.Llink = node;
							
							head = node;
							
							status = newData +" inserted to list.";
							flag = true;
						}
						else if(next == last) {
							
							node.Rlink = null;
							
							node.Llink = last;
							
							last.Rlink = node;
							
							last = node;
							
							status = newData +" inserted to list.";
							flag = true;
						}
						else {
							
							next.Llink.Rlink = node;
							
							node.Llink = next.Llink;
							
							node.Rlink = next;
							
							next.Llink = node;
							
							status = newData +" inserted to list.";
							flag = true;
						}
					}
					else 
						AddNode(newData, in, next.Rlink);
				}
				else {
					status = in +" is not found!";
					flag = false;
				}
		    }
				/*System.out.print("Enter node data: ");
				 * 
				newData = input.next();
		}*/
	}
}
