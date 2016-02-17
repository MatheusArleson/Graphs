package br.com.xavier.graphs.impl;

import br.com.xavier.graphs.abstraction.SimpleDirectedGraph;
import br.com.xavier.graphs.impl.factory.WeightedEdgesFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;

public class SimpleDirectedWeightedGraph extends SimpleDirectedGraph {

	public SimpleDirectedWeightedGraph(NodeFactory nodeFactory, WeightedEdgesFactory edgeFactory) {
		super(nodeFactory, edgeFactory);
	}

}
