package br.com.xavier.graphs.abstractions.simple.undirected;

import java.util.Set;

import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.abstractions.simple.SimpleGraph;
import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.interfaces.UndirectedGraph;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.util.messages.Util;

//FIXME TERMINAR IMPLEMETACAO
public abstract class SimpleUndirectedGraph<N extends AbstractNode, E extends Edge<N>> extends SimpleGraph<N,E> implements UndirectedGraph<N,E> {

	private static final boolean IS_DIRECTED = false;
	
	protected SimpleUndirectedGraph(boolean isWeighted) {
		super(IS_DIRECTED, isWeighted);
	}
	
	@Override
	public int degreeOf(N node) throws IllegalNodeException, NullPointerException {
		Util.checkNullParameter(node);
		Util.checkIllegalNode(this, node);
		
		Set<E> allEdges = getAllEdges(node);
		return allEdges.size()/2;
	}

}
