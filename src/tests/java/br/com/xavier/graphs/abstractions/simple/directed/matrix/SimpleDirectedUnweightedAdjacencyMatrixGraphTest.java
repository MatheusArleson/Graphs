package br.com.xavier.graphs.abstractions.simple.directed.matrix;

import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public abstract class SimpleDirectedUnweightedAdjacencyMatrixGraphTest<N extends AbstractNode, E extends AbstractEdge<N>> 
				extends SimpleDirectedAdjacencyMatrixGraphTest<N, E>{
	
	//XXX UTIL METHODS
	
	protected SimpleDirectedUnweightedAdjacencyMatrixGraph<N, E> getAsSimpleDirectedUnweightedAdjacencyMatrixGraphInstance() {
		return (SimpleDirectedUnweightedAdjacencyMatrixGraph<N, E>) graph;
	}
	
	//XXX TEST METHODS
	
}
