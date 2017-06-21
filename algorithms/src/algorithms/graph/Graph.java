package algorithms.graph;

import java.util.Iterator;
import java.util.LinkedList;



/*
 * 
 * BFS and DFS of 
 * directed graph
 * 
 */
public class Graph {

	private int V;
	private LinkedList<Integer> adjList[];
		
	Graph(int v){
		V = v;
		adjList = new LinkedList[v];
		for(int i=0;i<v;i++){
			adjList[i]=new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int w){
		adjList[v].add(w);
	}
	
	public void BFS(int s){
		boolean[] visited = new boolean[V]; 
		
		LinkedList<Integer> queue = new LinkedList<Integer>(); 
		queue.add(s);
		visited[s]=true;
		
		while(!queue.isEmpty()){
			s = queue.poll();
			System.out.println(" "+s);
			
			Iterator<Integer> i = adjList[s].listIterator();
			while(i.hasNext()){
				int n = i.next();
				if(!visited[n]){
					queue.add(n);
					visited[n]=true;
				}
			}
		}
		
	}
	
	public void DFS(){
		boolean[] visited = new boolean[V];
		for(int i=0;i<V;i++){
			if(!visited[i]){
				DFSUtil(i, visited);
			}
		}
	}
	
	public void DFSUtil(int v, boolean[] visited){
		
		visited[v]=true;
		System.out.println(" "+v);
		
		Iterator<Integer> i = adjList[v].listIterator();
		while(i.hasNext()){
			int n = i.next();
			if(!visited[n]){
				DFSUtil(n, visited);
			}
		}
	}
	
	
	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		//g.BFS(2);
		g.DFS();
	}
	
}
