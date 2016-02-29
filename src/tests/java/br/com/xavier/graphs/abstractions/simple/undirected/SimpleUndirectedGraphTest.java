package br.com.xavier.graphs.abstractions.simple.undirected;

import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.abstractions.simple.SimpleGraphTest;

public abstract class SimpleUndirectedGraphTest<N extends AbstractNode, E extends AbstractEdge<N>> extends SimpleGraphTest<N, E> {
	
	//XXX UTIl METHODS
	
	private SimpleUndirectedGraph<N, E> getAsSUGraphInstance() {
		return (SimpleUndirectedGraph<N, E>) graph;
	}
	
	//XXX TEST METHODS
	

}
