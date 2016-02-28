package br.com.xavier.graphs.abstractions.simple.directed;

import java.util.Set;

import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.abstractions.simple.SimpleGraph;
import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.interfaces.DirectedGraph;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.interfaces.nodes.Node;

//FIXME TERMINAR IMPLEMETACAO
public class SimpleDirectedGraph<N extends AbstractNode, E extends Edge<N>> extends SimpleGraph<N,E> implements DirectedGraph<N,E> {
	
	private static final boolean IS_DIRECTED = true;
	
	public SimpleDirectedGraph(boolean isWeighted) {
		super(IS_DIRECTED, isWeighted);
	}
	
	@Override
	public int inDegreeOf(Node node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int outDegreeOf(Node node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<E> incomingEdgesOf(Node node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<E> outgoingEdgesOf(Node node) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public int degreeOf(N node) throws IllegalNodeException, NullPointerException {
		// TODO Auto-generated method stub
		return 0;
	}
}
