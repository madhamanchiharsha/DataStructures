/**
 * 
 */
package model;

import java.util.LinkedList;

/**
 * @author 320069988
 *
 */
public class Graph {

	private int v;
	private LinkedList<Integer> adj[];
	
	public void add(int source, int destination) {
		this.adj[source].add(destination);
	}
	
	
	public int getV() {
		return v;
	}


	public void setV(int v) {
		this.v = v;
	}


	public LinkedList<Integer>[] getAdj() {
		return adj;
	}


	public void setAdj(LinkedList<Integer>[] adj) {
		this.adj = adj;
	}


	/**
	 * 
	 */
	public Graph(int v) {
		// TODO Auto-generated constructor stub
		this.v = v;
		this.adj = new LinkedList[v]; //Generic arrays are not possible in java 
		for(int i=0; i<this.adj.length; i++) {
			this.adj[i] = new LinkedList();
		}
	}

}
