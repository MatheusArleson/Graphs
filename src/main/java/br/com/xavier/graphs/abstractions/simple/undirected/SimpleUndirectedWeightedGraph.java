package br.com.xavier.graphs.abstractions.simple.undirected;

import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public abstract class SimpleUndirectedWeightedGraph<N extends AbstractNode, E extends AbstractWeightedEdge<N,T>, T extends Comparable<T>> 
				extends SimpleUndirectedGraph<N,E> {
	
	public static final boolean IS_WEIGHTED = true;

	public SimpleUndirectedWeightedGraph() {
		super(IS_WEIGHTED);
	}
}
