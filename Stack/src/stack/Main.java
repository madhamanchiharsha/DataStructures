package stack;

import java.util.Arrays;

import stack.model.SingleLinkedListNode;

public class Main {
    // implementing stack using single Linked list
	
	SingleLinkedListNode<String> top = null;
	SingleLinkedListNode<String> bottom = null;
	
	public void push(String data) {
		// TODO Auto-generated method stub
		if(this.top == null) { // when stack is empty
			this.top = new SingleLinkedListNode<String>(data, null);
			this.bottom = this.top;
			return;
		}
		SingleLinkedListNode<String> newNode = new SingleLinkedListNode<String>(data,null);
		SingleLinkedListNode<String> temp = this.bottom;
		while(temp.getNext() != null){
			temp = temp.getNext();
		}
		temp.setNext(newNode);
		this.top = newNode;
	}
	
	public void display() {
		// TODO Auto-generated method stub
		SingleLinkedListNode<String> temp = this.bottom;
		if(temp == null) {
			System.out.println("Stack is Empty");
			return;
		}
		while(temp.getNext() != null) {
			temp = temp.getNext();
		}
		System.out.println("    "+temp.getData());
	}
	public String peek() {
		// TODO Auto-generated method stub
		if(this.top == null) {
			//System.out.println("Stack is empty");
			return null;
		}
		return this.top.getData();
	}
	
	public String pop() {
		// TODO Auto-generated method stub
		SingleLinkedListNode<String> temp = this.bottom;
		SingleLinkedListNode<String> prev = null;
		if(temp == null) {
			System.out.println("Stack is empty so cant pop ");
		}
		while(temp != this.top) {
			prev = temp;
			temp = temp.getNext();
		}
		if(prev == null) {
			
			this.bottom = null;
			this.top = null;
			return temp.getData();
		}
		String popedItem = temp.getData(); 
		prev.setNext(null);
		this.top = prev;
		return popedItem;
	}
	
	public static void main(String[] args) {
		Main obj = new Main();
		obj.push("A");
		obj.push("B");
		obj.display();
		System.out.println("peek in stack "+obj.peek());
		System.out.println("poped--"+obj.pop());
		System.out.println("poped--"+obj.pop());
		System.out.println("-----");
		obj.display();
	}
}
