package br.com.xavier.graphs.abstractions.simple.undirected.matrix;

import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public abstract class SimpleUndirectedWeightedAdjacencyMatrixGraphTest<N extends AbstractNode, E extends AbstractWeightedEdge<N,T>, T> 
		extends SimpleUndirectedAdjacencyMatrixGraphTest<N, E>{
	
	//XXX UTIL METHODS
	
	protected SimpleUndirectedWeightedAdjacencyMatrixGraph<N, E, T> getAsSimpleUndirectedWeightedAdjacencyMatrixGraphInstance() {
		return (SimpleUndirectedWeightedAdjacencyMatrixGraph<N, E, T>) graph;
	}
	
	//XXX TEST METHODS
	
}
