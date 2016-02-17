package br.com.xavier.graphs.abstraction;

import br.com.xavier.graphs.interfaces.factory.EdgeFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;

public abstract class ComplexGraph extends SetBackedGraph {

	private static final boolean LOOPS_ALLOWED = true;
	private static final boolean MULTIPLE_EDGES_ALLOWED = false;
	
	public ComplexGraph(NodeFactory nodeFactory, EdgeFactory edgeFactory) {
		super(nodeFactory, edgeFactory, LOOPS_ALLOWED, MULTIPLE_EDGES_ALLOWED);
	}

}
