package br.com.xavier.graphs.abstractions.simple.undirected.matrix;

import java.util.Set;

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
		
		int degree = 0;
		
		Set<N> allNodesSet = getAllNodes();
		for (N currentNode : allNodesSet) {
			boolean existsEdge = existsEdge(node, currentNode);
			if(existsEdge){
				degree++;
			}
		}
		
		return degree;
	}

}
