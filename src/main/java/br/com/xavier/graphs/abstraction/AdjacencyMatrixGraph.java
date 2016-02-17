package br.com.xavier.graphs.abstraction;

import br.com.xavier.graphs.interfaces.factory.EdgeFactory;
import br.com.xavier.graphs.interfaces.factory.NodeFactory;

public abstract class AdjacencyMatrixGraph extends SetBackedGraph {

	public AdjacencyMatrixGraph(NodeFactory nodeFactory, EdgeFactory edgeFactory, boolean loopsAllowed, boolean multipleEdgesAllowed) {
		super(nodeFactory, edgeFactory, loopsAllowed, multipleEdgesAllowed);
	}

}
