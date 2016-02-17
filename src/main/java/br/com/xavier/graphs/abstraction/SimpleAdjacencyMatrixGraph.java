package br.com.xavier.graphs.abstraction;

import br.com.xavier.graphs.interfaces.factory.EdgeFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;

public abstract class SimpleAdjacencyMatrixGraph<N,E> extends AdjacencyMatrixGraph {
	
	private static final boolean LOOPS_ALLOWED = false;
	private static final boolean MULTIPLE_EDGES_ALLOWED = false;
	
	public SimpleAdjacencyMatrixGraph(NodeFactory nodeFactory, EdgeFactory edgeFactory) {
		super(nodeFactory, edgeFactory, LOOPS_ALLOWED, MULTIPLE_EDGES_ALLOWED);
	}
	
}
