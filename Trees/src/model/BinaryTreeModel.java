package model;

public class BinaryTreeModel<T> {
	
	private T data;
	private BinaryTreeModel<T> left;
	private BinaryTreeModel<T> right;
	
	public BinaryTreeModel(BinaryTreeModel<T> left,T data,BinaryTreeModel<T> right){
		this.left = left;
		this.right = right;
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BinaryTreeModel<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeModel<T> left) {
		this.left = left;
	}

	public BinaryTreeModel<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeModel<T> right) {
		this.right = right;
	}

}
