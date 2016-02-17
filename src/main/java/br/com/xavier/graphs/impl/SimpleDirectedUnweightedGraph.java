package br.com.xavier.graphs.impl;

import br.com.xavier.graphs.abstraction.SimpleDirectedGraph;
import br.com.xavier.graphs.impl.factory.UnweightedEdgesFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;

public class SimpleDirectedUnweightedGraph extends SimpleDirectedGraph {

	public SimpleDirectedUnweightedGraph(NodeFactory nodeFactory, UnweightedEdgesFactory edgeFactory) {
		super(nodeFactory, edgeFactory);
	}

}
