package br.com.xavier.graphs.abstractions.simple.directed.matrix;

import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public abstract class SimpleDirectedWeightedAdjacencyMatrixGraph<N extends AbstractNode, E extends AbstractWeightedEdge<N>> 
				extends SimpleDirectedAdjacencyMatrixGraph<N, E> {
	
	private static final boolean IS_WEIGHTED = true;
	
	public SimpleDirectedWeightedAdjacencyMatrixGraph() {
		super(IS_WEIGHTED);
	}
}
