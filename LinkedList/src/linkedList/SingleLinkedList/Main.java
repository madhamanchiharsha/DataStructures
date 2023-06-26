/**
 * @author Harsha Madhamanchi
 *
 */
package linkedList.SingleLinkedList;

import linkedList.SingleLinkedList.model.SingleLinkedListNode;


public class Main {

	public static SingleLinkedListNode<Integer> head;
	
	/*
	* insertion code for singly linked list
	*/

	public void insertAtEnd(int data, SingleLinkedListNode<Integer> head){
		if(this.head == null || head == null) {
			this.head = new SingleLinkedListNode<Integer>((Integer)data,null);
			return;
		}
		SingleLinkedListNode<Integer> newNode = new SingleLinkedListNode<Integer>((Integer)data,null);
		SingleLinkedListNode<Integer> temp = head; 
		while(temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(newNode);
	}
	
	 /*
	 * for displaying linked list  
	 */
	
	public void display(SingleLinkedListNode<Integer> head) {
		if(head == null) {
			System.out.println("Linked List is Empty");
			return ;
		}
		SingleLinkedListNode<Integer> temp = head; 
		while(temp.next !=null) {
			System.out.print(temp.getData()+" -> ");
			temp = temp.getNext();
		}
		System.out.print(temp.getData());
	}
	
	 /*
	 * for updating element based on location from linked list (replace)
	 */
	
	public void update(int data, int location) {
		if(head == null) {
			System.out.println("Linked List is Empty");
			return ;
		}
		SingleLinkedListNode<Integer> temp = head;
		int counter = 0;
		while(temp != null && counter<=location ) {
			if(counter == location) {
				temp.setData((Integer)data);
			}
			counter++;
			temp = temp.next;
		}
	}
	
	public int getLengthofLinkedList(SingleLinkedListNode<Integer> head) {
		SingleLinkedListNode<Integer> temp =head;
		int length = 0;
		while(temp != null) {
			temp = temp.next;
			length++;
		}
		return length;
	}
	
	/*
	 * for updating linked list based on location (create new node and insert any where in linked list)
	 */
	
	public void updateNewNode(int data, int location) {
		if(head == null ) {
			System.out.println("Linked List is Empty");
			return ;
		}
		if(location> this.getLengthofLinkedList(head)) {
			System.out.println("Length of linked list is smaller than the position given");
			return;
		}
		SingleLinkedListNode<Integer> temp = head;
		SingleLinkedListNode<Integer> newNode = new SingleLinkedListNode<Integer>((Integer)data,null);
		SingleLinkedListNode<Integer> prev = null;
		int counter = 0;
		while(temp != null && counter<=location ) {
			if(counter == location && prev != null) {
				prev.next = newNode;
				newNode.next = temp;
				return;
			} else if(counter == location && prev == null) {
				newNode.next = temp;
				this.head = newNode;
			}
			counter++;
			prev = temp;
			temp = temp.next;
		}
	}
	
	 /*
	 * for deleting element from linked list 
	 */
	
	public void delete(int data,SingleLinkedListNode<Integer> head) {
		if(head == null) {
			System.out.println("Linked List is Empty");
			return ;
		}
		SingleLinkedListNode<Integer> temp = head;
		SingleLinkedListNode<Integer> prev = null;
		while(temp != null && temp.getData() != (Integer)data) {
			prev = temp;
			temp = temp.next;
		} 
		if(temp.getData() == (Integer)data && prev != null) {
			prev.next = temp.next;
		} if(temp.getData() == (Integer)data && prev == null) {
			this.head = this.head.getNext();
		}

	}
	
	/**
	 * launch operation for single linked list from the main method
	 */
	public static void main(String[] args) {
		Main object = new Main();
		object.insertAtEnd(0, head);
		object.insertAtEnd(1, head);
		object.insertAtEnd(2, head);
		object.insertAtEnd(3, head);
		object.insertAtEnd(4, head);
		object.display(head);
		object.delete(4, head); // deletion at end of LinkedList
		System.out.println();
		object.display(head);
		object.delete(0, head); // deletion at start of LinkedList
		System.out.println();
		object.display(head);
		object.delete(2, head); // deletion at middle of LinkedList
		System.out.println();
		object.display(head);
		object.update(0, 1);
		System.out.println();
		object.display(head);
		object.updateNewNode(11, 0);
		System.out.println();
		object.display(head);
		object.updateNewNode(22, 2);
		System.out.println();
		object.display(head);


	}

}
