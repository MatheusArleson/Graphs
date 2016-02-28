package br.com.xavier.graphs.abstractions.simple.directed;

import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public abstract class SimpleDirectedUnweightedGraph<N extends AbstractNode, E extends AbstractEdge<N>> extends SimpleDirectedGraph<N,E> {
	
	private static final boolean IS_WEIGHTED = false;
	
	public SimpleDirectedUnweightedGraph() {
		super(IS_WEIGHTED);
	}

}
