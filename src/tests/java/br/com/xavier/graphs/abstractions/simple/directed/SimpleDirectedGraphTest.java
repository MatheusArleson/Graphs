package br.com.xavier.graphs.abstractions.simple.directed;

import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.abstractions.simple.SimpleGraph;
import br.com.xavier.graphs.abstractions.simple.SimpleGraphTest;

public abstract class SimpleDirectedGraphTest<N extends AbstractNode, E extends AbstractEdge<N>> extends SimpleGraphTest<N, E>{
	
	//XXX UTIL METHODS
	
	protected SimpleGraph<N, E> getAsSimpleGraphInstance() {
		return (SimpleGraph<N, E>) graph;
	}
	
	//XXX TEST METHODS
	
}
