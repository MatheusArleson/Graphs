package br.com.xavier.graphs.abstractions.simple.directed.matrix;

import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public abstract class SimpleDirectedWeightedAdjacencyMatrixGraphTest<N extends AbstractNode, E extends AbstractWeightedEdge<N,T>, T> 
				extends SimpleDirectedAdjacencyMatrixGraphTest<N, E>{
	
	//XXX UTIL METHODS
	
	protected SimpleDirectedWeightedAdjacencyMatrixGraph<N, E, T> getAsSimpleDirectedWeightedAdjacencyMatrixGraphInstance() {
		return (SimpleDirectedWeightedAdjacencyMatrixGraph<N, E, T>) graph;
	}
	
	//XXX TEST METHODS
	
}
