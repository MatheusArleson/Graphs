package br.com.xavier.graphs.abstraction;

import br.com.xavier.graphs.interfaces.factory.EdgeFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;

public abstract class AdjacencyMatrixGraph extends MapBackedGraph {
	
	public AdjacencyMatrixGraph(
		NodeFactory nodeFactory, EdgeFactory edgeFactory, 
		boolean isDirected, boolean isWeighted, boolean loopsAllowed, boolean multipleEdgesAllowed
	) {
		super(nodeFactory, edgeFactory, isDirected, isWeighted, loopsAllowed, multipleEdgesAllowed);
	}
	
	
}
