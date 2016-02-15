package br.com.xavier.graphs.impl;

import br.com.xavier.graphs.interfaces.factory.EdgeFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;

public class ComplexUnidirectedSetBackedGraph<N,E> extends UndirectedSetBackedGraph<N, E>{

	public ComplexUnidirectedSetBackedGraph(NodeFactory<N> nodeFactory, EdgeFactory<N, E> edgeFactory) {
		super(nodeFactory, edgeFactory, false, true);
	}

}
