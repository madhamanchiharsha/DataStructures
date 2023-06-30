package doubleEndedQueue;

import linearQueue.model.SingleLinkedListNode;

public class Main {
	SingleLinkedListNode<Integer> rear = null;
	SingleLinkedListNode<Integer> front = null;
	
	private void enqueue(int data, boolean isFront) {
		// TODO Auto-generated method stub
		if(this.front == null && this.rear == null) {
			this.rear = new SingleLinkedListNode<Integer>(data, null);
			this.front = this.rear;
			return;
		}
		SingleLinkedListNode<Integer> temp = this.front;
		SingleLinkedListNode<Integer> newNode = new SingleLinkedListNode<Integer>(data,null);
		if(isFront) {
			temp = this.front;
			this.front = newNode;
			newNode.setNext(temp);
			return;
		}
		while(temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(newNode);
		this.rear = newNode;
	}
	
	private void dequeue(boolean isRemoveFromFront) {
		// TODO Auto-generated method stub
		if(this.front == null && this.rear == null) {
			System.out.println("Queue is Empty");
			return;
		}
		SingleLinkedListNode<Integer> temp = this.front;
		SingleLinkedListNode<Integer> prev = null;
		if(isRemoveFromFront) {
			if(this.front != null && this.front.getNext() != null) {
				this.front = this.front.next;
				return;
			}
			this.front = null;
			this.rear = null;
			return;
		}
 		while(temp.getNext() != null) {
 			prev = temp;
			temp = temp.getNext();
		} if(prev == null) {
			this.rear = null;
			this.front = null;
			return;
		}
		prev.setNext(null);
		this.rear = prev;
	}
	
	private int peek(boolean isFromFront) throws Exception{
		// TODO Auto-generated method stub
		if(this.front == null && this.rear == null) {
			System.out.println("Queue is Empty");
			throw new Exception("Queue is Empty");
		}
		if(isFromFront) {
			return this.front.getData();
		}
		SingleLinkedListNode<Integer> temp = this.front;
		while(temp.getNext() != null) {
			temp =temp.getNext();
		}
		return temp.getData();
		

	}
	
	private void display() {
		// TODO Auto-generated method stub
		if(this.front == null && this.rear == null) {
			System.out.println("Queue is Empty");
			return;
		}
		SingleLinkedListNode<Integer> temp =this.front;
		while(temp.getNext() != null) {
			System.out.print(temp.getData()+" -> ");
			temp = temp.getNext();
		}
		System.out.println(temp.getData());
	}
	
	public static void main(String[] args) throws Exception {
		Main obj = new Main();
		obj.enqueue(1, false);
		obj.display();
		obj.enqueue(2, false);
		obj.display();
		obj.enqueue(0, true);
		obj.display();
		System.out.println("peek : "+obj.peek(true));
		obj.dequeue(false);
		obj.display();
		System.out.println("peek : "+obj.peek(true));
		obj.dequeue(true);
		obj.display();
		System.out.println("peek : "+obj.peek(false));
		obj.dequeue(false);
		obj.display();
		//obj.peek(true); thorws Exception as no element in queue
		
	}

}
