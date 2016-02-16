package br.com.xavier.graphs.abstraction;

import br.com.xavier.graphs.interfaces.factory.EdgeFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;

public abstract class ComplexAdjacencyMatrixGraph<N,E> extends AdjacencyMatrixGraph<N, E> {

	private static final boolean LOOPS_ALLOWED = true;
	private static final boolean MULTIPLE_EDGES_ALLOWED = false;
	
	public ComplexAdjacencyMatrixGraph(NodeFactory<N> nodeFactory, EdgeFactory<N, E> edgeFactory) {
		super(nodeFactory, edgeFactory, LOOPS_ALLOWED, MULTIPLE_EDGES_ALLOWED);
	}
	
}
