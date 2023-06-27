/**
 * 
 */
package linkedList.SingleCircularLinkedList;

import linkedList.SingleLinkedList.model.SingleLinkedListNode;

/**
 * @author Harsha Madhamanchi
 *
 */
public class Main {
	
	SingleLinkedListNode<Integer> startPoint;
	
	private void insertAtEnd(int data) {
		// TODO Auto-generated method stub
		if(this.startPoint == null) {
			startPoint = new SingleLinkedListNode<Integer>(data,null);
			startPoint.setNext(startPoint);
			return;
		}
		SingleLinkedListNode<Integer> newNode = new SingleLinkedListNode<Integer>(data,this.startPoint); 
		SingleLinkedListNode<Integer> temp = this.startPoint;
		while(temp.getNext() != this.startPoint) {
			temp =temp.getNext();
		}
		temp.setNext(newNode);
	}
	
	private void displayCircularLinkedList() {
		// TODO Auto-generated method stub
		if (this.startPoint == null) {
			System.out.println("Given circular linke dlist is Empty");
		}
		SingleLinkedListNode<Integer> temp = this.startPoint;
		while(temp.getNext() != this.startPoint) {
			System.out.print(temp.getData()+" -> ");
			temp =temp.getNext();
		}
		System.out.println(temp.getData());	
	}
	
	public void displayLinearLinkedList(SingleLinkedListNode<Integer> head) {
		if(head == null) {
			System.out.println("Linked List is Empty");
			return ;
		}
		SingleLinkedListNode<Integer> temp = head; 
		while(temp.next !=null) {
			System.out.print(temp.getData()+" -> ");
			temp = temp.getNext();
		}
		System.out.println(temp.getData());
	}
	
	private void breakLinkedListIntoLinear(SingleLinkedListNode<Integer> head) {
		// TODO Auto-generated method stub
		if(head == null) {
			System.out.println("Given linked list is empty");
		}
		SingleLinkedListNode<Integer> temp = head;
		while(temp.getNext() != head) {
			temp = temp.getNext();
		}
		temp.setNext(null);
	}
	
	private void deleteByElement(int data) {
		// TODO Auto-generated method stub
		if(this.startPoint == null) {
			System.out.println("Given linked list is empty");
		}
		SingleLinkedListNode<Integer> temp = this.startPoint;
		SingleLinkedListNode<Integer> prev = null;
		while(temp.getNext() != this.startPoint) {
			if(data == (Integer)temp.getData()) {
				break;
			}
			prev = temp;
			temp = temp.getNext();
		}
		if(prev == null) {
			temp = this.getLastNode(this.startPoint);
			temp.setNext(this.startPoint.getNext());
			this.startPoint = this.startPoint.getNext();
		}
		if(data == (Integer)temp.getData()) {
			prev.setNext(temp.getNext());
			return;
		}
	}
	
	private SingleLinkedListNode<Integer> getLastNode(SingleLinkedListNode<Integer> head){
		SingleLinkedListNode<Integer> temp = head;
		while(temp.getNext() != head) {
			temp = temp.getNext();
		}
		return temp;
	}
	
	private void deleteByNodeLocation(int location) {
		// TODO Auto-generated method stub
		if(this.startPoint == null) {
			System.out.println("Linked List is Empty");
			return;
		}
		SingleLinkedListNode<Integer> temp = this.startPoint;
		SingleLinkedListNode<Integer> prev = null;
		int counter = 0;
		while(temp.getNext() != this.startPoint && counter < location) {
			prev = temp;
			temp = temp.getNext();
			counter++;
		} if(counter == 0 ) {
			prev = this.getLastNode(startPoint);
			prev.setNext(startPoint.getNext());
			this.startPoint = startPoint.getNext();
			return;
		} 
		prev.setNext(temp.getNext());
		

	}
	
	private SingleLinkedListNode<Integer> convertToCircularLinkedList(SingleLinkedListNode<Integer> head) {
		// TODO Auto-generated method stub
		SingleLinkedListNode<Integer> temp = head;
		while(temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(head);
		return temp.getNext();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main object = new Main();
		object.insertAtEnd(0);
		object.insertAtEnd(1);
		object.insertAtEnd(2);
		object.insertAtEnd(3);
		object.displayCircularLinkedList();
		object.breakLinkedListIntoLinear(object.startPoint);
		object.displayLinearLinkedList(object.startPoint);
		object.startPoint = object.convertToCircularLinkedList(object.startPoint);
		object.displayCircularLinkedList();
		object.deleteByElement(2);
		object.displayCircularLinkedList();
		object.deleteByNodeLocation(2);
		object.displayCircularLinkedList();
	}

}
