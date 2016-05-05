package br.com.xavier.graphs.abstractions.simple.undirected;

import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public abstract class SimpleUndirectedWeightedGraphTest <N extends AbstractNode, E extends AbstractWeightedEdge<N,T>, T extends Comparable<T>> 
				extends SimpleUndirectedGraphTest<N, E>{

	//XXX UTIL METHODS
	
	protected SimpleUndirectedGraph<N, E> getAsSUGraphInstance() {
		return (SimpleUndirectedGraph<N, E>) graph;
	}
	
	//XXX TEST METHODS

}