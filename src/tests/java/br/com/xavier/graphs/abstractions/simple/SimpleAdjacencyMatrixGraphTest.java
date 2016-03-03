package br.com.xavier.graphs.abstractions.simple;

import br.com.xavier.graphs.abstractions.AdjacencyMatrixGraphTest;
import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public abstract class SimpleAdjacencyMatrixGraphTest<N extends AbstractNode, E extends AbstractEdge<N>> extends AdjacencyMatrixGraphTest<N, E> {
	
	//XXX UTIl METHODS
	
	private SimpleAdjacencyMatrixGraph<N,E> getAsSimpleAdjacencyMatrixGraphInstance() {
		return (SimpleAdjacencyMatrixGraph<N, E>) graph;
	}
	
	//XXX TEST METHODS
	
}
