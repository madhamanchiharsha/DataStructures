/**
 * 
 */
package circularQueue;

import linearQueue.model.SingleLinkedListNode;

/**
 * @author 320069988
 *
 */
public class Main {

	SingleLinkedListNode<Integer> front = null;
	SingleLinkedListNode<Integer> rear = null;
	
	private void enqueue(int data) {
		// TODO Auto-generated method stub
		if(this.front == null && this.rear == null) {
			this.rear = new SingleLinkedListNode<Integer>(data,null);
			this.rear.setNext(rear);
			this.front = this.rear;
			return;
		}
		
		SingleLinkedListNode<Integer> temp = this.front;
		SingleLinkedListNode<Integer> newNode = new SingleLinkedListNode<Integer>(data,null);
		while(temp.getNext() != this.front) {
			temp = temp.getNext();
		}
		temp.setNext(newNode);
		newNode.setNext(this.front);
		this.rear = newNode;
	}
	
	private void dequeue() {
		// TODO Auto-generated method stub
		if(this.front == null && this.rear == null) {
			System.out.println("Queue is Empty");
			return;
		}
		SingleLinkedListNode<Integer> temp = this.front;
		SingleLinkedListNode<Integer> prev = null;
		while(temp.getNext() != this.front) {
			prev = temp;
			temp = temp.getNext();
		} 
		if(prev == null || this.front.getNext() == null) {
			this.front = null;
			this.rear = null;
			return;
		}
		this.front = this.front.getNext();
		temp.setNext(this.front);
	}
	
	private void display() {
		// TODO Auto-generated method stub
		if(this.front == null && this.rear == null) {
			System.out.println("Queue is Empty");
			return;
		}
		SingleLinkedListNode<Integer> temp = this.front;
		while(temp.getNext() != this.front) {
			System.out.print(temp.getData()+" -> ");
			temp = temp.getNext();
		}
		System.out.println(temp.getData());
	}
	
	private SingleLinkedListNode<Integer> peek() {
		// TODO Auto-generated method stub
		if(this.front == null && this.rear == null) {
			System.out.println("Queue is Empty");
			return null;
		}
		return this.front;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main obj = new Main();
		obj.enqueue(0);
		obj.enqueue(1);
		obj.enqueue(2);
		obj.enqueue(3);
		obj.enqueue(4);
		obj.display();
		System.out.println("peek : "+obj.peek().getData());
		obj.dequeue();
		obj.dequeue();
		obj.display();
		System.out.println("peek : "+obj.peek().getData());
		obj.dequeue();
		obj.dequeue();
		obj.dequeue();
		obj.display();

	}

}
