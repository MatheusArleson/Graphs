package br.com.xavier.graphs.impl.algorithms.transversal;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import br.com.xavier.graphs.abstractions.algorithms.transversal.AbstractTransversalAlgorithm;
import br.com.xavier.graphs.impl.algorithms.NodeInfo;
import br.com.xavier.graphs.interfaces.Graph;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.interfaces.nodes.Node;
import br.com.xavier.graphs.util.Util;

public class BFSAlgorithm extends AbstractTransversalAlgorithm {
	
	//XXX CONSTRUCTOR
	public BFSAlgorithm(){ }
	
	//XXX OVERRIDE METHODS
	@Override
	public <N extends Node, E extends Edge<N>> List<NodeInfo> doAlgorithm(Graph<N, E> graph, N root){
		Util.checkIllegalNode(graph, root);
		
		Map<N, NodeInfo> nodesInfoMap = generateNodesInfoMap(graph);
		
		Queue<N> queue = new LinkedList<>();
		queue.add(root);
		
		int currentDistance = 0;
		
		NodeInfo rootNodeInfo = nodesInfoMap.get(root);
		rootNodeInfo.setVisited(true);
		rootNodeInfo.setDistance(currentDistance);
		
		List<NodeInfo> resultList = new LinkedList<>();
		resultList.add(rootNodeInfo);
		
		while(!queue.isEmpty()){
			N currentNode = queue.poll();
			
			Set<E> distinctEdges = graph.getDistinctEdges(currentNode);
			for (E edge : distinctEdges) {
				N adjacentNode = edge.getTarget();
				NodeInfo adjacentNodeInfo = nodesInfoMap.get(adjacentNode);
				
				if(!adjacentNodeInfo.isVisited()){
					adjacentNodeInfo.setVisited(true);
					adjacentNodeInfo.setDistance(currentDistance + 1);
					adjacentNodeInfo.setParent(currentNode);
					
					queue.add(adjacentNode);
					resultList.add(adjacentNodeInfo);
				}
			}
			
			currentDistance++;
		}
		
		return Collections.unmodifiableList(resultList);
	}
}
