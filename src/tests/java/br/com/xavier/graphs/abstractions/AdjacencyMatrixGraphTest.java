package br.com.xavier.graphs.abstractions;

import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;

public abstract class AdjacencyMatrixGraphTest<N extends AbstractNode, E extends AbstractEdge<N>> extends MapBackedGraphTest<N, E>{

	//XXX UTIL  METHODS
	
	private MapBackedGraph<N, E> getAsAdjacencyMatrixGraphInstance() {
		return (AdjacencyMatrixGraph<N, E>) graph;
	}
	
	//XXX TEST METHODS
	
	
	//REMOVE EDGE SOURCE TARGET -> CHECK ON UNDIRECTED EDGES IF THEY ARE REMOVED IN PAIRS
}
