package br.com.xavier.graphs.abstractions.simple.directed;

import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public abstract class SimpleDirectedWeightedGraph<N extends AbstractNode, E extends AbstractWeightedEdge<N>> extends SimpleDirectedGraph<N,E> {
	
	private static final boolean IS_WEIGHTED = true;
	
	public SimpleDirectedWeightedGraph() {
		super(IS_WEIGHTED);
	}

}
