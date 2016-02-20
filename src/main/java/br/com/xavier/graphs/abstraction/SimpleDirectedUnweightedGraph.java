package br.com.xavier.graphs.abstraction;

import br.com.xavier.graphs.impl.factory.UnweightedEdgesFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;

public abstract class SimpleDirectedUnweightedGraph extends SimpleDirectedGraph {
	
	private static final boolean IS_WEIGHTED = true;
	
	public SimpleDirectedUnweightedGraph(NodeFactory nodeFactory, UnweightedEdgesFactory edgeFactory) {
		super(nodeFactory, edgeFactory, IS_WEIGHTED);
	}

}
