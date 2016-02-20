package br.com.xavier.graphs.abstraction;

import br.com.xavier.graphs.impl.factory.WeightedEdgesFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;

public abstract class SimpleUndirectedWeightedGraph extends SimpleUndirectedGraph {
	
	public static final boolean IS_WEIGHTED = true;

	public SimpleUndirectedWeightedGraph(NodeFactory nodeFactory, WeightedEdgesFactory edgeFactory) {
		super(nodeFactory, edgeFactory, IS_WEIGHTED);
	}
}
