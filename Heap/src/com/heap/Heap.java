package com.heap;

import java.util.LinkedList;

public class Heap {

	int arr[] = {1,2,3,417,22,21212};
	
	LinkedList<Integer> ll = new LinkedList<Integer>();
	
	public Heap() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	private int getParentPosition(int currentPosition) {
		return currentPosition/2;
	}
	
	private int getLeftPosition(int currentPosition) {
		return currentPosition*2;
	}
	
	private int getRightPosition(int currentPosition) {
		return currentPosition*2+1;
	}
	
	private boolean isLeaf(int pos) {
		return (pos > ll.size()/2) ? true : false;
	}
	
	private void swap(int sourcePosition, int destinationPosition) {
		ll.set(sourcePosition, ll.get(sourcePosition)+ll.get(destinationPosition));
		ll.set(destinationPosition, ll.get(sourcePosition)-ll.get(destinationPosition));
		ll.set(sourcePosition, ll.get(sourcePosition)-ll.get(destinationPosition));
	}
	
	public void insert(int data) {
		ll.add(data);
		int currentPosition = ll.size()-1;
		while(ll.get(currentPosition) < ll.get(this.getParentPosition(currentPosition))) {
			this.swap(ll.get(currentPosition), ll.get(this.getParentPosition(currentPosition)));
			currentPosition = this.getParentPosition(currentPosition);
		}
	}
	 private void print(int currentPos) {
		// TODO Auto-generated method stub
		 for(int i=0; i<arr.length/2;i++) {
			 System.out.println(ll.get(i)+" left : "+ll.get(this.getLeftPosition(i))+"right : "+ll.get(this.getRightPosition(i)));
		 }
	}
	
	private  void min_heapify(int position) {
		// TODO Auto-generated method stub
		int swapPos = position;
		if(!this.isLeaf(position)) {
			if(this.getRightPosition(position) <= ll.size()) {
				swapPos = ll.get(this.getLeftPosition(position)) <= ll.get(this.getRightPosition(position)) ? this.getLeftPosition(position):this.getRightPosition(position);
			} else {
				swapPos = this.getLeftPosition(position);
			}
			if(ll.get(this.getLeftPosition(position)) <= ll.get(position) || ll.get	(this.getRightPosition(position)) <= ll.get(position)) {
				this.swap(swapPos, position);
				this.min_heapify(swapPos);
			}
		}
		
	}
	
	public static void main(String[] args) {
		
	}
}
