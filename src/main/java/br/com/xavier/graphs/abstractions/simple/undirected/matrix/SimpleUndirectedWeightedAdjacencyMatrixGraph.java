package br.com.xavier.graphs.abstractions.simple.undirected.matrix;

import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public abstract class SimpleUndirectedWeightedAdjacencyMatrixGraph<N extends AbstractNode, E extends AbstractWeightedEdge<N,T>, T> 
				extends SimpleUndirectedAdjacencyMatrixGraph<N, E>{
	
	private static final boolean IS_WEIGHTED = true;

	public SimpleUndirectedWeightedAdjacencyMatrixGraph() {
		super(IS_WEIGHTED);
	}

}
