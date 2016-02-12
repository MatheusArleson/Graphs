package br.com.xavier.graphs.interfaces;

public abstract  interface EdgeFactory<N, E> {

	public abstract E createEdge(N sourceNode, N targetNode);
	
}
