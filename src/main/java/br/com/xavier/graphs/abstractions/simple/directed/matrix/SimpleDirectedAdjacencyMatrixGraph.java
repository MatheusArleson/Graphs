package br.com.xavier.graphs.abstractions.simple.directed.matrix;

import java.util.LinkedHashSet;
import java.util.Set;

import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.abstractions.simple.SimpleAdjacencyMatrixGraph;
import br.com.xavier.graphs.exception.IllegalNodeException;
import br.com.xavier.graphs.interfaces.DirectedGraph;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.util.Util;

public abstract class SimpleDirectedAdjacencyMatrixGraph<N extends AbstractNode, E extends Edge<N>> 
				extends SimpleAdjacencyMatrixGraph<N, E> 
				implements DirectedGraph<N, E>{
	
	private static final boolean IS_DIRECTED = true;
	
	public SimpleDirectedAdjacencyMatrixGraph(boolean isWeighted) {
		super(IS_DIRECTED, isWeighted);
	}

	@Override
	public int degreeOf(N node) throws IllegalNodeException, NullPointerException {
		Util.checkNullParameter(node);
		Util.checkIllegalNode(this, node);
		
		return Math.abs(inDegreeOf(node) - outDegreeOf(node));
	}

	@Override
	public int inDegreeOf(N node) {
		Util.checkNullParameter(node);
		Util.checkIllegalNode(this, node);
		return incomingEdgesOf(node).size();
	}

	@Override
	public int outDegreeOf(N node) {
		Util.checkNullParameter(node);
		Util.checkIllegalNode(this, node);
		
		return outgoingEdgesOf(node).size();
	}

	@Override
	public Set<E> incomingEdgesOf(N node) {
		Util.checkNullParameter(node);
		Util.checkIllegalNode(this, node);
		
		Set<E> incomingEdges = new LinkedHashSet<>();
		Set<N> allNodes = getAllNodes();
		for (N sourceNode : allNodes) {
			if(existsEdge(sourceNode, node)){
				incomingEdges.addAll(getAllEdges(sourceNode, node));
			}
		}
		
		return incomingEdges;
	}

	@Override
	public Set<E> outgoingEdgesOf(N node) {
		Util.checkNullParameter(node);
		Util.checkIllegalNode(this, node);
		
		Set<E> outgoingEdges = new LinkedHashSet<>();
		Set<N> allNodes = getAllNodes();
		for (N targetNode : allNodes) {
			if(existsEdge(node, targetNode)){
				outgoingEdges.addAll(getAllEdges(node, targetNode));
			}
		}
		
		return outgoingEdges;
	}
}
