package br.com.xavier.graphs.abstractions.simple.directed;

import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public abstract class SimpleDirectedUnweightedGraphTest<N extends AbstractNode, E extends AbstractEdge<N>> extends SimpleDirectedGraphTest<N, E> {
	
	//XXX UTIl METHODS
	
	protected SimpleDirectedGraph<N, E> getAsSDGraphInstance() {
		return (SimpleDirectedGraph<N, E>) graph;
	}
	
	//XXX TEST METHODS
	
}
