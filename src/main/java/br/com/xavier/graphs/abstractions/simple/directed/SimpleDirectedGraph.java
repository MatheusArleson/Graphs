package br.com.xavier.graphs.abstractions.simple.directed;

import java.util.LinkedHashSet;
import java.util.Set;

import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.abstractions.simple.SimpleGraph;
import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.interfaces.DirectedGraph;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.util.Util;

public abstract class SimpleDirectedGraph<N extends AbstractNode, E extends Edge<N>> extends SimpleGraph<N,E> implements DirectedGraph<N,E> {
	
	private static final boolean IS_DIRECTED = true;
	
	protected SimpleDirectedGraph(boolean isWeighted) {
		super(IS_DIRECTED, isWeighted);
	}
	
	@Override
	public int outDegreeOf(N node) {
		Util.checkNullParameter(node);
		Util.checkIllegalNode(this, node);
		
		return outgoingEdgesOf(node).size();
	}
	
	@Override
	public int inDegreeOf(N node) {
		Util.checkNullParameter(node);
		Util.checkIllegalNode(this, node);
		
		return incomingEdgesOf(node).size();
	}

	@Override
	public Set<E> incomingEdgesOf(N node) {
		Util.checkNullParameter(node);
		Util.checkIllegalNode(this, node);
		
		Set<E> allEdges = getAllEdges();
		Set<E> incomingEdges = new LinkedHashSet<>();
		for (E edge : allEdges) {
			N targetNode = edge.getTarget();
			if(targetNode.equals(node)){
				incomingEdges.add(edge);
			}
		}
		
		return incomingEdges;
	}

	@Override
	public Set<E> outgoingEdgesOf(N node) {
		Util.checkNullParameter(node);
		Util.checkIllegalNode(this, node);
		
		return getAllEdges(node);
	}
	
	@Override
	public int degreeOf(N node) throws IllegalNodeException, NullPointerException {
		Util.checkNullParameter(node);
		Util.checkIllegalNode(this, node);
		
		return Math.abs(inDegreeOf(node) - outDegreeOf(node));
	}
}
