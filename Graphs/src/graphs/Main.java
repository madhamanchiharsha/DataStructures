/**
 * 
 */
package graphs;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

import model.Graph;

/**
 * @author 320069988
 *
 */
public class Main {

	static int v = 0;
	static Graph g = null;
	
	private void printBFS(int source) {
		boolean visited[] = new boolean[v];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(source);
		visited[source] = true;
		while(queue.size() != 0) {
			int value = queue.poll();
			System.out.println(" "+value);
			Iterator<Integer> i = g.getAdj()[source].listIterator();
			while(i.hasNext()) {
				int val = i.next();
				if(!visited[val]) {
					visited[val] = true;
					queue.add(val);
				}
			}	
		}
	}
	
	private void printDFS(int source, boolean [] visited) {
		visited[source] = true;
		System.out.print(source+" ");
		Iterator<Integer> i = g.getAdj()[source].iterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				printDFS(n,visited);
			}
		}
	}
	
	private void DFS(int source) {
		boolean visited[] = new boolean[v];
		printDFS(source,visited);
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter number of nodes/vertices for graph");
		v = new BufferedReader(new InputStreamReader(System.in)).read();
		g = new Graph(v);
		Main obj = new Main();
		g.add(0, 1);
		g.add(0, 2);
		g.add(0, 3);
		g.add(1, 2);		
		obj.printBFS(0);
		obj.DFS(1);
	}

}
