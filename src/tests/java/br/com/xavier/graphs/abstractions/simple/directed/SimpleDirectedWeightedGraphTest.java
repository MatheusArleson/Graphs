package br.com.xavier.graphs.abstractions.simple.directed;

import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public abstract class SimpleDirectedWeightedGraphTest<N extends AbstractNode, E extends AbstractWeightedEdge<N,T>, T> extends SimpleDirectedGraphTest<N, E> {
	
	//XXX UTIL METHODS
	
	protected SimpleDirectedGraph<N, E> getAsSDGraphInstance() {
		return (SimpleDirectedGraph<N, E>) graph;
	}
	
	//XXX TEST METHODS
	
}