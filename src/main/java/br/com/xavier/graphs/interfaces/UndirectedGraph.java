package br.com.xavier.graphs.interfaces;

/**
 * A Graph whose all Edges are undirected. </br> 
 * This is the root interface of all undirected Graphs. </br> 
 * 
 * @author Matheus Arleson
 *
 */
public abstract interface UndirectedGraph<N, E> extends Graph<N, E> {

	//TODO FIXME terminar implementacao
	 public abstract int degreeOf(N node);
	
}
