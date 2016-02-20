package br.com.xavier.graphs.abstraction.edges;

import br.com.xavier.graphs.abstraction.SimpleDirectedGraph;
import br.com.xavier.graphs.impl.factory.WeightedEdgesFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;

public abstract class SimpleDirectedWeightedGraph extends SimpleDirectedGraph {
	
	private static final boolean IS_WEIGHTED = true;
	
	public SimpleDirectedWeightedGraph(NodeFactory nodeFactory, WeightedEdgesFactory edgeFactory) {
		super(nodeFactory, edgeFactory, IS_WEIGHTED);
	}

}
