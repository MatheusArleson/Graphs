package br.com.xavier.graphs.impl;

import br.com.xavier.graphs.abstraction.SimpleUndirectedGraph;
import br.com.xavier.graphs.impl.factory.WeightedEdgesFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;

public class SimpleUndirectedWeightedGraph extends SimpleUndirectedGraph {

	public SimpleUndirectedWeightedGraph(NodeFactory nodeFactory, WeightedEdgesFactory edgeFactory) {
		super(nodeFactory, edgeFactory);
	}
}
