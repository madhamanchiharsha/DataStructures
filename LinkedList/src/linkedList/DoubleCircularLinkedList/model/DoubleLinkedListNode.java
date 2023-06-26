package linkedList.DoubleCircularLinkedList.model;

public class DoubleLinkedListNode<T> {
	T data;
	DoubleLinkedListNode<T> prev;
	DoubleLinkedListNode<T> next;
	public DoubleLinkedListNode(T data,DoubleLinkedListNode<T> prev,DoubleLinkedListNode<T> next) {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public DoubleLinkedListNode<T> getPrev() {
		return prev;
	}
	public void setPrev(DoubleLinkedListNode<T> prev) {
		this.prev = prev;
	}
	public DoubleLinkedListNode<T> getNext() {
		return next;
	}
	public void setNext(DoubleLinkedListNode<T> next) {
		this.next = next;
	}

}
