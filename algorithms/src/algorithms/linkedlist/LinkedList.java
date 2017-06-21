package algorithms.linkedlist;

/*
 * 
 * Method 2:
Traverse linked list using two pointers. Move one pointer by one and other pointer by two. 
When the fast pointer reaches end slow pointer will reach middle of the linked list.

 */
class Node{
	int val;
	Node next;
	Node(int v){
		val=v;
		next=null;
	}
}
public class LinkedList {

	
	Node first;
	LinkedList(Node n){
		first=n;
	}
	
	public void printLinkedList(Node node){
		if(node==null){
			return;
		}
		while(node!=null){
			System.out.print(node.val+"->");
			node=node.next;
		}
		System.out.println("NULL");

	}
	
	public int printMiddle(){
		Node slow=first;
		Node fast=first;
		if(first!=null)
		{
			while(fast!=null && fast.next!=null){
				slow=slow.next;
				fast=fast.next.next;
			}	
		}
		System.out.println("Middle value is: "+slow.val);
		return slow.val;
		
	}
	
	public Node reverseLinkedList(Node head){
		if(head==null || head.next==null)return null;
		Node curr=head,  prev=null;
		while(curr!=null){
			Node temp=curr.next;
			curr.next=prev;
			prev=curr;
			curr = temp;
		}
		return prev;
	}
	
	public void detectAndRemoveCycle(LinkedList ll){
		if(ll!=null && ll.first!=null){
			Node head = ll.first;
			Node slow=head, fast=head;
			while(slow!=null && fast!=null && fast.next!=null){
				slow=slow.next;
				fast=fast.next.next;
				
				if(slow==fast){
					removeCycle(slow,head);
				}
			}
		}
	}
	
	public void removeCycle(Node loop, Node head){
		Node ptr1=head, ptr2=null;
		while(1==1){
			ptr2=loop;
			while(ptr2.next!=ptr1 && ptr2.next!=loop){
				ptr2=ptr2.next;
			}
			if(ptr2.next==ptr1){
				break;
			}
			ptr1=ptr1.next;
		}
		ptr2.next=null;
	}
	
	public static void main(String[] args) {
		Node n=new Node(2);
		
		LinkedList ll = new LinkedList(n);
		n.next=new Node(5);
		n.next.next=new Node(11);
		n.next.next.next=new Node(20);
		n.next.next.next.next=new Node(30);
		
		ll.printLinkedList(n);
		ll.printMiddle();
		Node n2=ll.reverseLinkedList(n);
		ll=new LinkedList(n2);
		ll.printLinkedList(n2); 
		
		
		Node cyclicNode=new Node(1);
		LinkedList ll2 = new LinkedList(cyclicNode);
		cyclicNode.next=new Node(2);
		cyclicNode.next.next=new Node(3);
		cyclicNode.next.next.next=new Node(4);
		cyclicNode.next.next.next.next=cyclicNode.next;
		//ll2.printLinkedList(cyclicNode); 
		ll2.detectAndRemoveCycle(ll2);
		ll2.printLinkedList(cyclicNode); 
	}

}
