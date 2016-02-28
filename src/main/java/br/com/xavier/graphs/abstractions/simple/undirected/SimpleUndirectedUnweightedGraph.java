package br.com.xavier.graphs.abstractions.simple.undirected;

import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public abstract class SimpleUndirectedUnweightedGraph<N extends AbstractNode, E extends AbstractEdge<N>> extends SimpleUndirectedGraph<N,E> {
	
	private static final boolean IS_WEIGHTED = false;

	public SimpleUndirectedUnweightedGraph() {
		super(IS_WEIGHTED);
	}
}
