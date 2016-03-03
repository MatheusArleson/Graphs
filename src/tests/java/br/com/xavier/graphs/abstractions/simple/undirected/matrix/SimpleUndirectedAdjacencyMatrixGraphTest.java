package br.com.xavier.graphs.abstractions.simple.undirected.matrix;

import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.abstractions.simple.SimpleAdjacencyMatrixGraphTest;

public abstract class SimpleUndirectedAdjacencyMatrixGraphTest<N extends AbstractNode, E extends AbstractEdge<N>> extends SimpleAdjacencyMatrixGraphTest<N, E>{
	
	//XXX UTIL METHODS
	
	protected SimpleUndirectedAdjacencyMatrixGraph<N, E> getAsSimpleUndirectedAdjacencyMatrixGraphInstance() {
		return (SimpleUndirectedAdjacencyMatrixGraph<N, E>) graph;
	}
	
	//XXX TEST METHODS
	
}
