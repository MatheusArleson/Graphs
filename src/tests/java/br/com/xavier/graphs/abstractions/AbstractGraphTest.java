package br.com.xavier.graphs.abstractions;

import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.interfaces.GraphTest;

public abstract class AbstractGraphTest<N extends AbstractNode, E extends AbstractEdge<N>> extends GraphTest<N,E> {
	
	//XXX UTIL METHODS
	
	private AbstractGraph<N, E> getAsAbstractGraphInstance() {
		return (AbstractGraph<N,E>) graph;
	}
	
	//XXX TEST METHODS

}
