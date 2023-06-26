/**
 * @author Harsha Madhamanchi
 *
 */
package linkedList.DoubleLinkedList;

import linkedList.DoubleLinkedList.model.DoubleLinkedListNode;

public class Main {

	DoubleLinkedListNode<Integer> head;

	public void insertAtEnd(int data) {
		if (this.head == null) {
			head = new DoubleLinkedListNode<Integer>(data, null, null);
			return;
		}
		DoubleLinkedListNode<Integer> newNode = new DoubleLinkedListNode<Integer>(data, null, null);
		DoubleLinkedListNode<Integer> prev = null;
		DoubleLinkedListNode<Integer> temp = this.head;
		while (temp != null) {
			prev = temp;
			temp = temp.getNext();
		}
		prev.setNext(newNode);
		newNode.setPrev(prev);
	}

	private int getLength() {
		// TODO Auto-generated method stub
		DoubleLinkedListNode<Integer> temp = this.head;
		int length = 0;
		while (temp != null) {
			temp = temp.getNext();
			length++;
		}
		return length;
	}
	
	

	private void insertAtLocation(int data, int location) {
		// TODO Auto-generated method stub
		if (this.head == null) {
			head = new DoubleLinkedListNode<Integer>(data, null, null);
			return;
		}
		if (location > this.getLength()) {
			System.out.println("length of linked list is smaller than provided");
			return;
		}
		int counter = 0;
		DoubleLinkedListNode<Integer> newNode = new DoubleLinkedListNode<Integer>(data, null, null);
		DoubleLinkedListNode<Integer> prev = null;
		DoubleLinkedListNode<Integer> temp = this.head;
		while (temp != null && counter < location) {
			prev = temp;
			temp = temp.getNext();
			counter++;
		}
		if (prev != null && counter != this.getLength()) {
			prev.setNext(newNode);
			newNode.setPrev(prev);
			newNode.setNext(temp);
			temp.setPrev(newNode);
			return;
		} else if (prev != null && counter == this.getLength()) {
			prev.setNext(newNode);
			newNode.setPrev(prev);
			newNode.setNext(null);
			return;
		} else if (prev == null) {
			newNode.setPrev(prev);
			newNode.setNext(temp);
			temp.setPrev(newNode);
			this.head = newNode;
		}
	}

	public void deleteNodeByData(int data) {
		if (this.head == null) {
			System.out.println("Linked list is Empty");
			return;
		}
		DoubleLinkedListNode<Integer> temp = head;
		while (temp != null) {
			if (temp.getData() == (Integer) data) {
				if (temp.getPrev() != null && temp.getNext() != null) {
					temp.getPrev().setNext(temp.getNext());
					temp.getNext().setPrev(temp.getPrev()); // any middle elements
					return;
				} else if (temp.getPrev() == null) {
					this.head = temp.getNext(); // first element
					return;
				} else if (temp.getNext() == null) {
					temp.getPrev().setNext(null); // last element
					return;
				}
			}
			temp = temp.getNext();
		}
	}
	
	private void deleteByNodeLocation(int location)  {
		if(this.head == null) {
		System.out.println("Linked list is Empty");
		}
		if(location > this.getLength()) {
			System.out.println("Linked list lenght is smaller that provided lcoation to be deleted");
			return;
		}
		int counter = 0;
		DoubleLinkedListNode<Integer> temp = this.head;
		while(temp.getNext() != null && counter < location) {
			temp = temp.getNext();
			counter++;
		} if(counter == 0) {
			this.head = head.getNext();
		} else if(counter == this.getLength()-1) {
			temp.getPrev().setNext(null);
		} else {
			
			temp.getPrev().setNext(temp.getNext());
			temp.getNext().setPrev(temp.getPrev());
		}
		
	}

	private void updateByValue(int existingValue, int updatedValue) {
		// TODO Auto-generated method stub
		if (this.head == null) {
			System.out.println("Linked list is Empty");
			return;
		}
		DoubleLinkedListNode<Integer> temp = head;
		while (temp != null) {
			if (temp.getData() == (Integer) existingValue) {
				temp.setData(updatedValue);
			}
			temp = temp.getNext();
		}
	}

	private void display() {
		// TODO Auto-generated method stub
		if (this.head == null) {
			System.out.println("Linked list is Empty");
			return;
		}
		DoubleLinkedListNode<Integer> temp = this.head;
		while (temp.getNext() != null) {
			System.out.print(temp.getData() + "->");
			temp = temp.getNext();
		}
		System.out.println(temp.getData());

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main object = new Main();
		object.insertAtEnd(0);
		object.insertAtEnd(1);
		object.insertAtEnd(2);
		object.insertAtEnd(3);
		object.insertAtEnd(4);
		object.display();
		object.updateByValue(4, 3);
		object.display();
		object.deleteNodeByData(3);
		object.display();
		object.insertAtLocation(10, 0);
		object.display();
		object.insertAtLocation(11, 5);
		object.display();
		object.insertAtLocation(22, 3);
		object.display();
		object.deleteByNodeLocation(6);
		object.display();

	}

}
