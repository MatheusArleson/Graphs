package br.com.xavier.graphs.abstractions.simple.undirected.matrix;

import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public abstract class SimpleUndirectedUnweightedAdjacencyMatrixGraphTest<N extends AbstractNode, E extends AbstractEdge<N>> extends SimpleUndirectedAdjacencyMatrixGraphTest<N, E>{
	
	//XXX UTIL METHODS
	
	protected SimpleUndirectedUnweightedAdjacencyMatrixGraph<N, E> getAsSimpleUndirectedUnweightedAdjacencyMatrixInstance() {
		return (SimpleUndirectedUnweightedAdjacencyMatrixGraph<N, E>) graph;
	}
	
	//XXX TEST METHODS
	
}
