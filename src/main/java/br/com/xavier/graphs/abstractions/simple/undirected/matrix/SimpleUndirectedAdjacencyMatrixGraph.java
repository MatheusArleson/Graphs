package br.com.xavier.graphs.abstractions.simple.undirected.matrix;

import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.abstractions.simple.SimpleAdjacencyMatrixGraph;
import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.interfaces.UndirectedGraph;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.util.Util;

public abstract class SimpleUndirectedAdjacencyMatrixGraph<N extends AbstractNode, E extends Edge<N>> 
				extends SimpleAdjacencyMatrixGraph<N,E> 
				implements UndirectedGraph<N,E> {

	private static final boolean IS_DIRECTED = false;
	
	protected SimpleUndirectedAdjacencyMatrixGraph(boolean isWeighted) {
		super(IS_DIRECTED, isWeighted);
	}
	
	@Override
	public int degreeOf(N node) throws IllegalNodeException, NullPointerException {
		Util.checkNullParameter(node);
		Util.checkIllegalNode(this, node);
		
		return 0;
	}

}
