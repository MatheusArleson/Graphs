package br.com.xavier.graphs.abstraction;

import br.com.xavier.graphs.interfaces.factory.EdgeFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;

public abstract class SimpleGraph extends MapBackedGraph {

	private static final boolean LOOPS_ALLOWED = false;
	private static final boolean MULTIPLE_EDGES_ALLOWED = false;
	
	public SimpleGraph(NodeFactory nodeFactory, EdgeFactory edgeFactory, boolean isDirected, boolean isWeighted) {
		super(nodeFactory, edgeFactory, isDirected, isWeighted, LOOPS_ALLOWED, MULTIPLE_EDGES_ALLOWED);
	}
	
}
