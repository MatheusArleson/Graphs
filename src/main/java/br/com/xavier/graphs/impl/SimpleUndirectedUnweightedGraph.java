package br.com.xavier.graphs.impl;

import br.com.xavier.graphs.abstraction.SimpleUndirectedGraph;
import br.com.xavier.graphs.impl.factory.UnweightedEdgesFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;

public class SimpleUndirectedUnweightedGraph extends SimpleUndirectedGraph {

	public SimpleUndirectedUnweightedGraph(NodeFactory nodeFactory, UnweightedEdgesFactory edgeFactory) {
		super(nodeFactory, edgeFactory);
	}
}
