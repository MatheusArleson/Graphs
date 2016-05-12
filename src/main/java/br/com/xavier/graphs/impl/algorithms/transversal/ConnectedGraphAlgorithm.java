package br.com.xavier.graphs.impl.algorithms.transversal;

import java.util.List;

import br.com.xavier.graphs.abstractions.algorithms.transversal.AbstractTransversalAlgorithm;
import br.com.xavier.graphs.impl.algorithms.NodeInfo;
import br.com.xavier.graphs.interfaces.Graph;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.interfaces.nodes.Node;
import br.com.xavier.graphs.util.Util;

public class ConnectedGraphAlgorithm {
	
	//XXX CONSTRUCTOR
	public ConnectedGraphAlgorithm(){}

	public <N extends Node, E extends Edge<N>> boolean checkGraphConnectionsByBFS(Graph<N, E> graph) {
		return checkGraphConnections(graph, new BFSAlgorithm());
	}
	
	public <N extends Node, E extends Edge<N>> boolean checkGraphConnectionsByDFS(Graph<N, E> graph) {
		return checkGraphConnections(graph, new DFSAlgorithm());
	}
	
	private <N extends Node, E extends Edge<N>> boolean checkGraphConnections(Graph<N, E> graph, AbstractTransversalAlgorithm alg) {
		Util.checkNullParameter(graph);
		
		if(graph.isEmpty()){
			return true;
		}
		
		N firstNode = graph.getAllNodes().iterator().next();
		List<NodeInfo> bfsReturn = alg.doAlgorithm(graph, firstNode);
		return bfsReturn.size() == graph.getAllNodes().size();
	}
}
