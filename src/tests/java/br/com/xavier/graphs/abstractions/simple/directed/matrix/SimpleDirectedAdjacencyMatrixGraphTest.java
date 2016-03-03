package br.com.xavier.graphs.abstractions.simple.directed.matrix;

import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.abstractions.simple.SimpleAdjacencyMatrixGraphTest;

public abstract class SimpleDirectedAdjacencyMatrixGraphTest<N extends AbstractNode, E extends AbstractEdge<N>> extends SimpleAdjacencyMatrixGraphTest<N, E>{
	
	//XXX UTIL METHODS
	
	protected SimpleDirectedAdjacencyMatrixGraph<N, E> getAsSimpleDirectedAdjacencyMatrixGraphInstance() {
		return (SimpleDirectedAdjacencyMatrixGraph<N, E>) graph;
	}
	
	//XXX TEST METHODS
	
}
