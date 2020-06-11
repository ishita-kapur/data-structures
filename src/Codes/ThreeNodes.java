/*
 * Author : Ishita Kapur
 */
package Codes;

import java.util.HashSet;

public class ThreeNodes {
	Node head; //head of the list
	
	//static so that main() can access it
	static class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}//constructor
	}
	
	public void printList() {
		Node n = head;
		while(n != null) {
			System.out.print(n.data + " ");
			n=n.next;
		}
	}
	
	/* This function inserts a 
	   new Node at front of the list. */
	public void insertFront(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}
	
	/* This function inserts a 
	   new Node after the specified node in the list. */
	public void insertAfter(Node prev_node, int new_data) {
		
		if(prev_node == null) {
			System.out.println("The previous node cannot be null");
			return;
		}
		Node new_node = new Node(new_data);
		new_node.next = prev_node.next;
		prev_node.next = new_node;
	}
	
	public void insertEnd(int new_data) {
		Node new_node = new Node(new_data);
		if(head == null) {
			head = new Node(new_data);
			return;
		}
		new_node.next = null;
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		last.next = new_node;
		return;
	}
	
	public void deleteNode(int key) {
		Node temp = head, prev = null;
		if(temp != null && temp.data == key) {
			head = temp.next;
			return;
		}
		while(temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}
		if(temp == null)
			return;
		prev.next = temp.next;
	}
	
	public void deleteNodePos(int position) {
		if(head == null) {
			return;
		}
		Node temp = head;
		if(position == 0) {
			head = temp.next;
			return;
		}
		for(int i = 0; temp!=null && i < position - 1; i++) {
			temp = temp.next;
		}
		if(temp == null || temp.next == null) {
			return;
		}
		Node next = temp.next.next;
		temp.next = temp;
	}
	
	public int lengthList() {
		Node temp = head;
		int count = 0;
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	public int recursiveGetLength(Node node) {
		if(node == null) {
			return 0;
		}
		return 1 + recursiveGetLength(node.next);
	}
	
	public int getLength()
	{
		return recursiveGetLength(head);
	}
	
	public void swapNodes(int x, int y) {
		if(x == y)
			return;
		
		//search for x and keep track of prev_x and curr_x
		Node prev_x = null, curr_x = head;
		while(curr_x != null && curr_x.data != x) {
			prev_x = curr_x;
			curr_x = curr_x.next;
		}
		
		//search for y and keep track of prev_y and curr_y
		Node prev_y = null, curr_y = head;
		while(curr_y != null && curr_y.data != y) {
			prev_y = curr_y;
			curr_y = curr_y.next;
		}
		
		if(curr_x == null || curr_y == null) {
			return;
		}
		
		//if x is not head of the linked list
		if(prev_x != null) {
			prev_x.next = curr_y;
		}
		else
			head = curr_y;
		
		//if y is not head of the linked list
		if(prev_y != null) {
			prev_y.next = curr_x;
		}
		else
			head = curr_x;
		
		//swap the pointers
		Node temp = curr_x.next;
		curr_x.next = curr_y.next;
		curr_y.next = temp;
	}
	/*
	Node reverseList(Node node) {
		Node prev = null;
		Node current = node;
		Node next = null;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}
	
	public Node reverse() {
		if(head == null || head.next == null) {
			return head;
		}
		Node rest = reverse();
		head.next.next = head;
		head.next = null;
		
		return rest;
	}*/
	
	//check whether a value x is present in the linked list
	public boolean search(int x) {
		Node current = head;
		while(current != null) {
			if(current.data == x)
				return true;
			current = current.next;
		}
		return false;
	}
	
	//recursive search
	public boolean recurSearch(Node head, int x) {
		if(head == null)
			return false;
		if(head.data == x)
			return true;
		return recurSearch(head.next, x);
	}
	
	public boolean rSearch(int x) {
		return recurSearch(head, x);
	}
	
	//Get nth node in a linked list
	public int GetNth(int index) {
		Node current = head;
		int count = 0;
		while(current != null) {
			if(count == index) {
				return current.data;
			}
			count ++;
			current = current.next;
		}
		assert(false);
		return 0;
	}
	
	//recursive getNth
	public int recurGetNth(Node head, int index) {
		int count = 0;
		if(head == null) {
			return -1;
		}
		if(count == index) {
			return head.data;
		}
		return recurGetNth(head.next, index-1);
	}
	
	public int rGetNth(int index) {
		return recurGetNth(head, index);
	}
	
	public int nthFromLast(int n) {
		int len = 0;
		Node temp = head;
		while(temp != null) {
			temp = temp.next;
			len ++;
		}
		if(len < n) {
			return -9999;
		}
		temp = head;
		for(int i = 1; i < len - n + 1; i++) {
			temp = temp.next;
		}
		return(temp.data);
	}
	
	//middle element of the linked list
	public int middleElement() {
		Node slow_ptr = head;
		Node fast_ptr = head;
		if(head != null) {
			while(fast_ptr != null && fast_ptr.next != null) {
				fast_ptr = fast_ptr.next.next;
				slow_ptr = slow_ptr.next;
			}
		}
		return(slow_ptr.data);
	}
	
	//count of element
	public int countEle(int ele) {
		Node current = head;
		int count = 0;
		while(current != null) {
			if(current.data == ele) {
				count ++;
			}
			current = current.next;
		}
		return count;
	}
	
	//check if there is a loop present in the linked list
	public boolean detectLoop() {
		HashSet<Node> s = new HashSet<Node>();
		Node current = head;
		while(current != null) {
			if(s.contains(current))
				return true;
			s.add(current);
			current = current.next;
		}
		return false;
	}
	
	//count nodes present in a Loop
	public int countNodes(Node n) {
		int res = 1;
		Node temp = n;
		while(temp.next != n) {
			res ++;
			temp = temp.next;
		}
		return res;
	}
	
	//detect a loop and count nodes in a loop
	public int countNodesinLoop() {
		Node slow_p = head, fast_p = head;
		while(slow_p != null && fast_p != null && fast_p.next != null) {
			slow_p = slow_p.next;
			fast_p = fast_p.next.next;
			if(slow_p == fast_p) {
				return countNodes(slow_p);
			}
		}
		return 0;
	}
	
	//method to create a linked list with three nodes
	public static void main(String args[]) {
		//create an empty linked list
		ThreeNodes l_list = new ThreeNodes();
		l_list.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		
		l_list.head.next = second;
		second.next = third;

		System.out.println("\nInitial Linked List");
		l_list.printList();
		System.out.println("\nInserting a new node in the front");
		l_list.insertFront(-1);
		l_list.printList();
		System.out.println("\nInserting a new node after a particular node");
		l_list.insertAfter(second, 4);
		l_list.printList();
		System.out.println("\nInserting a new node at the end");
		l_list.insertEnd(5);
		l_list.printList();
		System.out.println("\nDeleting a node from the list");
		l_list.deleteNode(1);
		l_list.printList();
		System.out.println("\nDeleting a node at a specified position");
		l_list.deleteNodePos(0);
		l_list.printList();
		int length = l_list.lengthList();
		System.out.println("\nLength of the Linked List is " + length);
		int rec_length = l_list.getLength();
		System.out.println("\nLength (Recursive) of the Linked List is " + rec_length);
		System.out.println("\nLinked List after swapping nodes");
		l_list.swapNodes(4, 3);
		l_list.printList();		
		//System.out.println("\nLinked List in reverse is");
		//l_list.reverse();
		//l_list.printList();
		System.out.println("\nCheck presence of a value in the linked list - Search");
		System.out.println(l_list.search(3));
		System.out.println("\nCheck presence of a value in the linked list - Recursive Search");
		System.out.println(l_list.rSearch(3));
		int index = 2;
		System.out.println("\nValue at index " + index + " is : " + l_list.GetNth(index));
		System.out.println("\nValue at index " + index + " is : " + l_list.rGetNth(index) + " - Recursive");
		int n = 4;
		int value = l_list.nthFromLast(n);
		System.out.println("\nValue at " + n + " position from the last is : " + value);
		int midEle = l_list.middleElement();
		System.out.println("\nMiddle Element of the Linked List is : " + midEle);
		l_list.insertEnd(7);
		System.out.println("\nInserted a new element in the Linked List. Updated Linked List is : ");
		l_list.printList();
		midEle = l_list.middleElement();
		System.out.println("\nMiddle Element of the Updated Linked List is : " + midEle);
		int ele = 4;
		int count = l_list.countEle(ele);
		System.out.println("\nCount of " + ele + " in the Linked List is : " + count);
		System.out.println("\nA loop is present in the Linked List : " + l_list.detectLoop());
		System.out.println("\nCount of Nodes in the Loop is : " + l_list.countNodesinLoop());
	}
}
