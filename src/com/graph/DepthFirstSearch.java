//package com.graph;
//
//import com.sun.corba.se.impl.orbutil.graph.Graph;
//
//public class DepthFirstSearch {
//	private boolean[]marked;
//	private int count;
//	public DepthFirstSearch（Graph G, int s）{
//		marked = new boolean [G.V()];
//		DepthFirstSearch(G,s);
//	}
//	private void dfs(Graph G, int v) {
//		marked[v]= true;
//		count ++;
//		for(int w :G.adj(v))
//			if(!marked[w])dfs(G, w);
//	}
//}
