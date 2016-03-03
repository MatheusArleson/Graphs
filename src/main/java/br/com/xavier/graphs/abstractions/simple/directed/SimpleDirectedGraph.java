package br.com.xavier.graphs.abstractions.simple.directed;

import java.util.Set;

import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.abstractions.simple.SimpleGraph;
import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.interfaces.DirectedGraph;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.util.messages.Util;

//FIXME TERMINAR IMPLEMETACAO
public abstract class SimpleDirectedGraph<N extends AbstractNode, E extends Edge<N>> extends SimpleGraph<N,E> implements DirectedGraph<N,E> {
	
	private static final boolean IS_DIRECTED = true;
	
	protected SimpleDirectedGraph(boolean isWeighted) {
		super(IS_DIRECTED, isWeighted);
	}
	
	@Override
	public int inDegreeOf(N node) {
		Util.checkNullParameter(node);
		Util.checkIllegalNode(this, node);
		
		Set<E> allEdges = getAllEdges(node);
		return 0;
	}

	@Override
	public int outDegreeOf(N node) {
		Util.checkNullParameter(node);
		Util.checkIllegalNode(this, node);
		
		return 0;
	}

	@Override
	public Set<E> incomingEdgesOf(N node) {
		Util.checkNullParameter(node);
		Util.checkIllegalNode(this, node);
		
		return null;
	}

	@Override
	public Set<E> outgoingEdgesOf(N node) {
		Util.checkNullParameter(node);
		Util.checkIllegalNode(this, node);
		
		return null;
	}
	
	@Override
	public int degreeOf(N node) throws IllegalNodeException, NullPointerException {
		Util.checkNullParameter(node);
		Util.checkIllegalNode(this, node);
		
		return 0;
	}
}
