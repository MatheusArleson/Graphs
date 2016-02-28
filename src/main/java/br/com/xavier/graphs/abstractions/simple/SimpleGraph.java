package br.com.xavier.graphs.abstractions.simple;

import br.com.xavier.graphs.abstractions.MapBackedGraph;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.interfaces.edges.Edge;

public abstract class SimpleGraph<N extends AbstractNode, E extends Edge<N>> extends MapBackedGraph<N,E> {

	private static final boolean LOOPS_ALLOWED = false;
	private static final boolean MULTIPLE_EDGES_ALLOWED = false;
	
	public SimpleGraph(boolean isDirected, boolean isWeighted) {
		super(isDirected, isWeighted, LOOPS_ALLOWED, MULTIPLE_EDGES_ALLOWED);
	}
	
}
