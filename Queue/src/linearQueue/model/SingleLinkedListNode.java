package linearQueue.model;

public class SingleLinkedListNode<T> {
	public T data;
	public SingleLinkedListNode<T> next;
	
	public SingleLinkedListNode(T data, SingleLinkedListNode<T> next) {
		this.data = data;
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public SingleLinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(SingleLinkedListNode<T> next) {
		this.next = next;
	}
	

}
