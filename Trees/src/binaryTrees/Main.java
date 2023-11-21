/**
 * 
 */
package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;


import model.BinaryTreeModel;

/**
 * @author 320069988
 *
 */
public class Main {

	static BinaryTreeModel<Integer> root;
	
	private int getHeightOfTree(BinaryTreeModel<Integer> node) {
		if(node == null) {
			return 0;
		} else {
			int lheight = getHeightOfTree(node.getLeft());
			int rheight = getHeightOfTree(node.getRight());
			if(lheight>rheight) {
				return lheight+1;
			} else {
				return rheight+1;
			}
		}
	}
	
	private void inserLevelOrder(BinaryTreeModel<Integer> node, int data) {
		// TODO Auto-generated method stub
		if (node == null) {
			root = new BinaryTreeModel<Integer>(null,data,null);
			System.out.print(root.getData()+"  ");
			return;
		} else {
			Queue<BinaryTreeModel<Integer>> queue= new LinkedList<BinaryTreeModel<Integer>>();
			queue.add(node);
			while(!queue.isEmpty()) {
				node = queue.peek();
				queue.remove();
				if(node.getLeft() == null) {
					node.setLeft(new BinaryTreeModel<Integer>(null, data, null));
					System.out.print(node.getLeft().getData()+"  ");
					break;
				} else {
					queue.add(node.getLeft());
				}
				if(node.getRight() == null) {
					node.setRight(new BinaryTreeModel<Integer>(null, data, null));
					System.out.print(node.getRight().getData()+"  ");
					break;
				} else {
					queue.add(node.getRight());
				}
			}
		}
	}
	
	private void printLevelOrder(BinaryTreeModel<Integer> node) {
		// TODO Auto-generated method stub
		if(node == null) {
			return;
		}
		Queue<BinaryTreeModel<Integer>> queue = new LinkedList<BinaryTreeModel<Integer>>();
		queue.add(node);
		while(!queue.isEmpty()) {
			node  = queue.peek();
			queue.remove();
			System.out.print(node.getData()+"  ");
			if(node.getLeft()!=null) {
				queue.add(node.getLeft());
			} if(node.getRight() != null) {
				queue.add(node.getRight());
			}
		}
	}
	
	private void printInorder(BinaryTreeModel<Integer> node) {
		// TODO Auto-generated method stub
		if(node == null) {
			return;
		}
		printInorder(node.getLeft());
		System.out.print(node.getData()+"  ");
		printInorder(node.getRight());

	}
	
	private void printPreOrder(BinaryTreeModel<Integer> node) {
		// TODO Auto-generated method stub
		if(node == null) {
			return;
		}
		System.out.print(node.getData()+"  ");
		printPreOrder(node.getLeft());
		printPreOrder(node.getRight());
	}
	
	private void printPostOrder(BinaryTreeModel<Integer> node) {
		// TODO Auto-generated method stub
		if(node == null) return;
		printPostOrder(node.getLeft());
		printPostOrder(node.getRight());
		System.out.print(node.getData()+"  ");
	}
	BinaryTreeModel<Integer> temp;
	
	private void deleteByData(BinaryTreeModel<Integer> currentNode, int data) {
		// TODO Auto-generated method stub
		if(currentNode == null) {
			return;
		}
		if(currentNode.getLeft() == null && currentNode.getRight() == null) {	
			if(currentNode.getData().equals(data)) {
				currentNode = null;
				return;
			} else {
				return;
			}
		}
		Queue<BinaryTreeModel<Integer>> queue = new LinkedList<BinaryTreeModel<Integer>>();
		queue.add(currentNode);
		
		BinaryTreeModel<Integer> temp = null, keyNode = null;
		
		while(!queue.isEmpty()) {
			temp = queue.peek();
			queue.remove();
			
			if(temp.getData().equals(data)) {
				keyNode = temp;
			}
			if(temp.getLeft() != null) {
				queue.add(temp.getLeft());
			}
			if(temp.getRight()!=null) {
				queue.add(temp.getRight());
			}
		}
		if(keyNode != null) {
			int x = temp.getData();
			this.deleteDeepestNode(root, temp);
			keyNode.setData(x);
		}
		
	}
	
	private void deleteDeepestNode(BinaryTreeModel<Integer> root,BinaryTreeModel<Integer> deleteNode) {
		// TODO Auto-generated method stub
		Queue<BinaryTreeModel<Integer>> queue = new LinkedList<BinaryTreeModel<Integer>>();
		queue.add(root);
		
		BinaryTreeModel<Integer> temp = null;
		while(!queue.isEmpty()) {
			temp = queue.peek();
			queue.remove();
			
			if(temp == deleteNode) {
				temp = null;
				return;
			}
			if(temp.getRight() != null) {
				if(temp.getRight() == deleteNode) {
					temp.setRight(null);
				} else {
					queue.add(temp.getRight());
				}
			}
			if(temp.getLeft() != null) {
				if(temp.getLeft() == deleteNode) {
					temp.setLeft(null);
				} else {
					queue.add(temp.getLeft());
				}
			}
		}
		

	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Main obj = new Main();
//		System.out.println("for 0");
		obj.inserLevelOrder(root, 0);
//		System.out.println("for 1");
		obj.inserLevelOrder(root, 1);
//		System.out.println("for 2");
		obj.inserLevelOrder(root, 2);
//		System.out.println("for 3");
		obj.inserLevelOrder(root, 3);
//		System.out.println("for 4");
		obj.inserLevelOrder(root, 4);
		System.out.println();
	    System.out.println("Insertion done");
	    obj.printLevelOrder(root);
	    System.out.println();
	    System.out.println("level order traversel done");
	    obj.printInorder(root);
	    System.out.println();
	    System.out.println("Inorder traversel done");
	    obj.printPreOrder(root);
	    System.out.println();
	    System.out.println("Preorder Traversel done");
	    obj.printPostOrder(root);
	    System.out.println();
	    System.out.println("Postorder traversel done");
	    
	    
	}

}
