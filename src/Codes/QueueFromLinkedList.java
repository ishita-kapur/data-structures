/*
 * Author : Ishita Kapur
 */
package Codes;

public class QueueFromLinkedList {
	private Node first, last;
	
	private class Node {
		String item;
		Node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void enqueue(String item) {
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty())
			first = last;
		else
			oldlast.next = last;
	}
	
	public String dequeue() {
		String item = first.item;
		first = first.next;
		if(isEmpty())
			last = null;
		return item;
	}

	public void contentQueue() {
		Node n = first;
		while(n != null) {
			System.out.print(n.item + " ");
			n=n.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		QueueFromLinkedList newQueue = new QueueFromLinkedList();
		
		newQueue.enqueue("Awesome");
		System.out.println("Content of the Queue is :");
		newQueue.contentQueue();
		
		newQueue.enqueue("is");
		System.out.println("Content of the Queue is :");
		newQueue.contentQueue();
		
		newQueue.enqueue("This");
		System.out.println("Content of the Queue is :");
		newQueue.contentQueue();
		
		newQueue.enqueue("Hello!");
		System.out.println("Content of the Queue is :");
		newQueue.contentQueue();
		
		String dequeuedItem = newQueue.dequeue();
		System.out.println("Dequeued Item : " + dequeuedItem);
		
		System.out.println("Content of the Queue is :");
		newQueue.contentQueue();
	}
}
