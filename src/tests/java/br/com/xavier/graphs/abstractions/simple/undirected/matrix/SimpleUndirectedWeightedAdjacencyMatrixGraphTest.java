package br.com.xavier.graphs.abstractions.simple.undirected.matrix;

import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public abstract class SimpleUndirectedWeightedAdjacencyMatrixGraphTest<N extends AbstractNode, E extends AbstractWeightedEdge<N>> 
		extends SimpleUndirectedAdjacencyMatrixGraphTest<N, E>{
	
	//XXX UTIL METHODS
	
	protected SimpleUndirectedWeightedAdjacencyMatrixGraph<N, E> getAsSimpleUndirectedWeightedAdjacencyMatrixGraphInstance() {
		return (SimpleUndirectedWeightedAdjacencyMatrixGraph<N, E>) graph;
	}
	
	//XXX TEST METHODS
	
}
