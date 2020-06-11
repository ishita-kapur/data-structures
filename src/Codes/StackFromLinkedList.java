/*
 * Author : Ishita Kapur
 */
package Codes;

public class StackFromLinkedList {
	private Node head = null;
	
	private class Node{
		String item;
		Node next;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void push(String item) {
		Node oldhead = head;
		head = new Node();
		head.item = item;
		head.next = oldhead;
	}
	
	public String pop() {
		String item = head.item;
		head = head.next;
		return item;
	}
	
	public void contentStack() {
		Node n = head;
		while(n != null) {
			System.out.print(n.item + " ");
			n=n.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		StackFromLinkedList newStack = new StackFromLinkedList();
		
		newStack.push("Awesome");
		System.out.println("Content of the Stack is :");
		newStack.contentStack();
		
		newStack.push("is");
		System.out.println("Content of the Stack is :");
		newStack.contentStack();
		
		newStack.push("This");
		System.out.println("Content of the Stack is :");
		newStack.contentStack();
		
		newStack.push("Hello!");
		System.out.println("Content of the Stack is :");
		newStack.contentStack();
		
		String poppedItem = newStack.pop();
		System.out.println("Popped Item : " + poppedItem);
		
		System.out.println("Content of the Stack is :");
		newStack.contentStack();
	}
}
