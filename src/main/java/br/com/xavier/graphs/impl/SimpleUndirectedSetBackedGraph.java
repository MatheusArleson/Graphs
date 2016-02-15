package br.com.xavier.graphs.impl;

import br.com.xavier.graphs.interfaces.factory.EdgeFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;

public class SimpleUndirectedSetBackedGraph<N,E> extends UndirectedSetBackedGraph<N, E>{

	public SimpleUndirectedSetBackedGraph(NodeFactory<N> nodeFactory, EdgeFactory<N, E> edgeFactory) {
		super(nodeFactory, edgeFactory, false, false);
	}

}
