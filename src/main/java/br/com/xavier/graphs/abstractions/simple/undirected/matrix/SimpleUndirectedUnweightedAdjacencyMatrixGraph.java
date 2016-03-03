package br.com.xavier.graphs.abstractions.simple.undirected.matrix;

import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public abstract class SimpleUndirectedUnweightedAdjacencyMatrixGraph<N extends AbstractNode, E extends AbstractEdge<N>> 
				extends SimpleUndirectedAdjacencyMatrixGraph<N,E> {
	
	private static final boolean IS_WEIGHTED = false;

	public SimpleUndirectedUnweightedAdjacencyMatrixGraph() {
		super(IS_WEIGHTED);
	}
	
}
