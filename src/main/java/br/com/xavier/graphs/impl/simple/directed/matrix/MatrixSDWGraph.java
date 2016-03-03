package br.com.xavier.graphs.impl.simple.directed.matrix;

import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.abstractions.simple.directed.matrix.SimpleDirectedWeightedAdjacencyMatrixGraph;

public class MatrixSDWGraph<N extends AbstractNode, E extends AbstractWeightedEdge<N>> 
		extends SimpleDirectedWeightedAdjacencyMatrixGraph<N, E> {
	
	public MatrixSDWGraph() {
	}
	
}
