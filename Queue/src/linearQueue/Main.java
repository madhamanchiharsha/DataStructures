/**
 * 
 */
package linearQueue;

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
		if(this.rear == null && this.front == null) { 
			this.rear = new SingleLinkedListNode<Integer>(data, null);
			this.front = this.rear;
			return;
		}
		SingleLinkedListNode<Integer> temp = this.front;
		SingleLinkedListNode<Integer> newNode = new SingleLinkedListNode<Integer>(data,null);
		while(temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(newNode);
		this.rear = newNode;
	}
	
	private SingleLinkedListNode<Integer> peek() {
		// TODO Auto-generated method stub
		if(this.front == null && this.rear == null) {
			System.out.println("Queue is Empty");
			return null;
		}
		return this.front;
	}
	
	private void display() {
		// TODO Auto-generated method stub
		if( this.rear ==null && this.front == null) { 
			System.out.println("Queue is empty");
			return;
		}
		SingleLinkedListNode<Integer> temp = this.front;
		while(temp.getNext() != null) {
			System.out.print(temp.getData()+" -> ");
			temp = temp.getNext();
		}
		System.out.println(temp.getData());
	}
	
	private void dequeue() {
		// TODO Auto-generated method stub
		if(this.rear == null && this.front == null) { 
			System.out.println("Rear and front both are empty");
			return;
		}
		this.front = this.front.getNext();
		if(this.front == null) {
			this.rear = null;
		}
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
		System.out.println("peek : "+obj.peek().getData());
		obj.display();
		obj.dequeue();
		obj.dequeue();
		obj.dequeue();
		obj.dequeue();
		obj.display();
	}

}
