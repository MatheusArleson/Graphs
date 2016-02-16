package br.com.xavier.graphs.abstraction;

import br.com.xavier.graphs.interfaces.factory.EdgeFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;

public abstract class AdjacencyMatrixGraph<N,E> extends SetBackedGraph<N, E> {

	public AdjacencyMatrixGraph(NodeFactory<N> nodeFactory, EdgeFactory<N, E> edgeFactory, boolean loopsAllowed, boolean multipleEdgesAllowed) {
		super(nodeFactory, edgeFactory, loopsAllowed, multipleEdgesAllowed);
	}

}
