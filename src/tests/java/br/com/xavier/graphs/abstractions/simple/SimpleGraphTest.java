package br.com.xavier.graphs.abstractions.simple;

import br.com.xavier.graphs.abstractions.MapBackedGraphTest;
import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public abstract class SimpleGraphTest<N extends AbstractNode, E extends AbstractEdge<N>> extends MapBackedGraphTest<N, E> {
	
	//XXX UTIl METHODS
	
	private SimpleGraph<N,E> getAsSimpleGraphInstance() {
		return (SimpleGraph<N, E>) graph;
	}
	
	//XXX TEST METHODS
	
}
