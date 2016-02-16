package br.com.xavier.graphs.abstraction;

import br.com.xavier.graphs.interfaces.factory.EdgeFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;

public abstract class SimpleGraph<N,E> extends SetBackedGraph<N, E> {

	private static final boolean LOOPS_ALLOWED = false;
	private static final boolean MULTIPLE_EDGES_ALLOWED = false;
	
	public SimpleGraph(NodeFactory<N> nodeFactory, EdgeFactory<N, E> edgeFactory) {
		super(nodeFactory, edgeFactory, LOOPS_ALLOWED, MULTIPLE_EDGES_ALLOWED);
	}

}
