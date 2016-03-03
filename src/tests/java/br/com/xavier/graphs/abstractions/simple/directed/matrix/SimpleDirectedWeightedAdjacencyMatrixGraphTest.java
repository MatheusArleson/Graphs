package br.com.xavier.graphs.abstractions.simple.directed.matrix;

import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public abstract class SimpleDirectedWeightedAdjacencyMatrixGraphTest<N extends AbstractNode, E extends AbstractWeightedEdge<N>> extends SimpleDirectedAdjacencyMatrixGraphTest<N, E>{
	
	//XXX UTIL METHODS
	
	protected SimpleDirectedWeightedAdjacencyMatrixGraph<N, E> getAsSimpleDirectedWeightedAdjacencyMatrixGraphInstance() {
		return (SimpleDirectedWeightedAdjacencyMatrixGraph<N, E>) graph;
	}
	
	//XXX TEST METHODS
	
}
