package br.com.xavier.graphs.abstractions.algorithms.transversal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.com.xavier.graphs.impl.algorithms.NodeInfo;
import br.com.xavier.graphs.interfaces.Graph;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.interfaces.nodes.Node;
import br.com.xavier.graphs.util.messages.MessageManager;

public abstract class AbstractTransversalAlgorithm {
	
	private static final String HASH_COLLISION_MESSAGE_KEY = "hash.collision";
	
	//XXX CONSTRUCTOR
	protected AbstractTransversalAlgorithm(){
		
	}
	
	//XXX ABSTRACT METHODS
	public abstract <N extends Node, E extends Edge<N>> List<NodeInfo> doAlgorithm(Graph<N, E> graph, N root);
	
	//XXX METHODS
	protected <N extends Node, E extends Edge<N>> Map<N, NodeInfo> generateNodesInfoMap(Graph<N, E> graph) {
		//work map
		Map<N, NodeInfo> nodesInfoMap = new LinkedHashMap<>(graph.getAllNodes().size());
		
		//initialize list
		for (N graphNode : graph.getAllNodes()) {
			NodeInfo nodeInfo = new NodeInfo(graphNode);
			NodeInfo previous = nodesInfoMap.put(graphNode, nodeInfo);
			if(previous != null){
				throw new RuntimeException(MessageManager.getMessage(HASH_COLLISION_MESSAGE_KEY));
			}
		}
		return nodesInfoMap;
	}

}
