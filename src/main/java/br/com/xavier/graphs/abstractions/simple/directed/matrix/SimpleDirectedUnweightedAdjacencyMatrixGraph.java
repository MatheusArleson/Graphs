package br.com.xavier.graphs.abstractions.simple.directed.matrix;

import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public abstract class SimpleDirectedUnweightedAdjacencyMatrixGraph<N extends AbstractNode, E extends AbstractEdge<N>> 
				extends SimpleDirectedAdjacencyMatrixGraph<N, E> {
	
	private static final boolean IS_WEIGHTED = false;
	
	public SimpleDirectedUnweightedAdjacencyMatrixGraph() {
		super(IS_WEIGHTED);
	}
}
