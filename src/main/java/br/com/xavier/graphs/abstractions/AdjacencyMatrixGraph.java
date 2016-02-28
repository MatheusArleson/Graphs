package br.com.xavier.graphs.abstractions;

import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.interfaces.edges.Edge;

public abstract class AdjacencyMatrixGraph<N extends AbstractNode, E extends Edge<N>> extends MapBackedGraph<N,E> {
	
	public AdjacencyMatrixGraph(
		boolean isDirected, boolean isWeighted, 
		boolean loopsAllowed, boolean multipleEdgesAllowed
	) {
		super(isDirected, isWeighted, loopsAllowed, multipleEdgesAllowed);
	}
	
	
	
	
}
