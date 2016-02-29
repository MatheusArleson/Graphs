package br.com.xavier.graphs.abstractions.simple.undirected;

import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public abstract class SimpleUndirectedUnweightedGraphTest<N extends AbstractNode, E extends AbstractEdge<N>> extends SimpleUndirectedGraphTest<N, E>{
	
	//XXX UTIl METHODS
	
	private SimpleUndirectedUnweightedGraph<N, E> getAsSUUGraphInstance() {
		return (SimpleUndirectedUnweightedGraph<N, E>) graph;
	}
	
	//XXX TEST METHODS

}
