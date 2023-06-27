/**
 * 
 */
package linkedList.DoubleCircularLinkedList;

import linkedList.DoubleLinkedList.model.DoubleLinkedListNode;

/**
 * @author Harsha Madhamanchi
 *
 */
public class Main {
	
	DoubleLinkedListNode<Integer> startPoint = null;
	private void insertIntoDoubleLinkedList(int data) {
		// TODO Auto-generated method stub
		if(this.startPoint == null) {
			this.startPoint = new DoubleLinkedListNode<Integer>(data, null,null);
			this.startPoint.setNext(startPoint);
			this.startPoint.setPrev(startPoint);
			return;
		}
		DoubleLinkedListNode<Integer> temp =this.startPoint;
		DoubleLinkedListNode<Integer> newNode = new DoubleLinkedListNode<Integer>(data,null,null);
		while(temp.getNext() != this.startPoint) {
			temp = temp.getNext();
		}
		temp.setNext(newNode);
		newNode.setPrev(temp);
		newNode.setNext(startPoint);
	}
	private void displayDoublyCircularLinkedList() {
		// TODO Auto-generated method stub
		if(this.startPoint == null) {
			System.out.println("Linked List is Empty");
			return;
		}
		DoubleLinkedListNode<Integer> temp = this.startPoint;
		while(temp.getNext() != this.startPoint) {
			System.out.print(temp.getData()+" -> ");
			temp = temp.getNext();
		}
		System.out.println(temp.getData());
	}
	
	private void breakDoubleCircularLinkedList(DoubleLinkedListNode<Integer> head) {
		// TODO Auto-generated method stub
		DoubleLinkedListNode<Integer> temp = head;
		while(temp.getNext() != head) {
			temp = temp.getNext();
		}
		temp.setNext(null);
		head.setPrev(null);
	}
	
	private void diplayDoubleLinearLinkedList(DoubleLinkedListNode<Integer> head) {
		// TODO Auto-generated method stub
		DoubleLinkedListNode<Integer> temp = head;
		while(temp.getNext() !=null) {
			System.out.print(temp.getData()+" -> ");
			temp = temp.getNext();
		}
		System.out.println(temp.getData());
	}
	
	private DoubleLinkedListNode<Integer> convertToDoubleCircularLinkedList(DoubleLinkedListNode<Integer> head) {
		// TODO Auto-generated method stub
		DoubleLinkedListNode<Integer> temp = head;
		while(temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(head);
		head.setPrev(temp);
		return temp.getNext();

	}
	
	private void deleteElementByValue(int data) {
		// TODO Auto-generated method stub
		DoubleLinkedListNode<Integer> temp = this.startPoint;
		do{
			if(temp.getData() == (Integer)data) {
				break;
			}
			temp = temp.getNext();
		
		} while(temp != this.startPoint);
		temp.getPrev().setNext(temp.getNext());
		temp.getNext().setPrev(temp.getPrev());
		if(temp == this.startPoint) {
			this.startPoint = this.startPoint.getNext();
		}
	}
	
	private void deleteElementByLocation(int location) {
		// TODO Auto-generated method stub
		DoubleLinkedListNode<Integer> temp = this.startPoint;
		int counter = 0;
		do {
			if(counter==location) {
				break;
			}
			temp = temp.getNext();
			counter++;
		}
		while(temp.getNext() != this.startPoint && counter<location);
		if(counter == 0) {
			this.startPoint.getPrev().setNext(startPoint.getNext());
			this.startPoint = this.startPoint.getNext();
		}
		temp.getPrev().setNext(temp.getNext());
		temp.getNext().setPrev(temp.getPrev());;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main object = new Main();
		object.insertIntoDoubleLinkedList(0);
		object.insertIntoDoubleLinkedList(1);
		object.insertIntoDoubleLinkedList(2);
		object.insertIntoDoubleLinkedList(3);
		object.insertIntoDoubleLinkedList(4);
		object.displayDoublyCircularLinkedList();
		object.breakDoubleCircularLinkedList(object.startPoint);
		object.diplayDoubleLinearLinkedList(object.startPoint);
		object.startPoint = object.convertToDoubleCircularLinkedList(object.startPoint);
		object.displayDoublyCircularLinkedList();
		object.deleteElementByValue(4);
		object.displayDoublyCircularLinkedList();
		object.deleteElementByLocation(3);
		object.displayDoublyCircularLinkedList();

	}

}
