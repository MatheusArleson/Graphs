package br.com.xavier.graphs.abstractions.simple;

import br.com.xavier.graphs.abstractions.AdjacencyMatrixGraph;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.interfaces.edges.Edge;

public abstract class SimpleAdjacencyMatrixGraph<N extends AbstractNode, E extends Edge<N>> extends AdjacencyMatrixGraph<N, E>{
	
	private static final boolean LOOPS_ALLOWED = false;
	private static final boolean MULTIPLE_EDGES_ALLOWED = false;
	
	public SimpleAdjacencyMatrixGraph(
		boolean isDirected, 
		boolean isWeighted 
	) {
		super(isDirected, isWeighted, LOOPS_ALLOWED, MULTIPLE_EDGES_ALLOWED);
	}
	
}
