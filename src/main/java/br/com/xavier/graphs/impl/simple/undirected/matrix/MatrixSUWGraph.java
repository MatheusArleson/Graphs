package br.com.xavier.graphs.impl.simple.undirected.matrix;

import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.abstractions.simple.undirected.matrix.SimpleUndirectedWeightedAdjacencyMatrixGraph;

public class MatrixSUWGraph<N extends AbstractNode, E extends AbstractWeightedEdge<N>> 
		extends SimpleUndirectedWeightedAdjacencyMatrixGraph<N, E> {
	
	public MatrixSUWGraph() {
	}
	
}
