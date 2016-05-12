package br.com.xavier.graphs.impl.algorithms;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import br.com.xavier.graphs.abstractions.AbstractGraph;
import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.exception.IllegalGraphException;
import br.com.xavier.graphs.impl.simple.directed.DefaultSDWGraph;
import br.com.xavier.graphs.impl.simple.undirected.DefaultSUWGraph;
import br.com.xavier.graphs.interfaces.Graph;
import br.com.xavier.graphs.interfaces.algorithms.GraphAlgorithms;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.interfaces.nodes.Node;
import br.com.xavier.graphs.util.messages.MessageManager;
import br.com.xavier.graphs.util.messages.Util;

public final class GraphAlgorithmsImpl implements GraphAlgorithms {
	
	private static final String HASH_COLLISION_MESSAGE_KEY = "hash.collision";
	private static final String GRAPH_NOT_WEIGHTED_MESSAGE_KEY = "graph.not.weighted";
	private static final String GRAPH_NOT_CONNECTED_MESSAGE_KEY = "graph.not.connected";
	private static final String GRAPH_EMPTY_MESSAGE_KEY = "graph.empty";
	
	//XXX CONSTRUCTOR
	//defeats instantiation
	public GraphAlgorithmsImpl(){ }
	
	//XXX TRASVERSAL METHODS
	@Override
	public <N extends Node, E extends Edge<N>> boolean isGraphConnected(Graph<N, E> graph) {
		Util.checkNullParameter(graph);
		
		if(graph.isEmpty()){
			return true;
		}
		
		N firstNode = graph.getAllNodes().iterator().next();
		List<NodeInfo> bfsReturn = BFS(graph, firstNode);
		return bfsReturn.size() == graph.getAllNodes().size();
	}
	
	@Override
	public <N extends Node, E extends Edge<N>> List<NodeInfo> BFS(Graph<N, E> graph, N root){
		//null checking and see if node is in the graph
		Util.checkIllegalNode(graph, root);
		
		//generate nodesInfoMap
		Map<N, NodeInfo> nodesInfoMap = generateNodesInfoMap(graph);
		
		//create work queue
		Queue<N> queue = new LinkedList<>();
		queue.add(root);
		
		//create var to hold distance (hop count)
		int currentDistance = 0;
		
		//get the correspondent node info from the map
		NodeInfo rootNodeInfo = nodesInfoMap.get(root);
		rootNodeInfo.setVisited(true);
		rootNodeInfo.setDistance(currentDistance);
		
		//generate list to hold result
		List<NodeInfo> resultList = new LinkedList<>();
		resultList.add(rootNodeInfo);
		
		while(!queue.isEmpty()){
			//get a node from the queue
			N currentNode = queue.poll();
			
			//discover new nodes
			Set<E> distinctEdges = graph.getDistinctEdges(currentNode);
			for (E edge : distinctEdges) {
				N adjacentNode = edge.getTarget();
				NodeInfo adjacentNodeInfo = nodesInfoMap.get(adjacentNode);
				
				//is node visited?
				if(!adjacentNodeInfo.isVisited()){
					adjacentNodeInfo.setVisited(true);
					adjacentNodeInfo.setDistance(currentDistance + 1);
					adjacentNodeInfo.setParent(currentNode);
					
					queue.add(adjacentNode);
					resultList.add(adjacentNodeInfo);
				}
			}
			
			//increment distance\hop count
			currentDistance++;
		}
		
		//return unmodifiable list
		return Collections.unmodifiableList(resultList);
	}
	
	public <N extends Node, E extends Edge<N>> List<NodeInfo> DFS(Graph<N, E> graph, N root){
		//null checking and see if node is in the graph
		Util.checkIllegalNode(graph, root);
		
		//generate nodesInfoMap
		Map<N, NodeInfo> nodesInfoMap = generateNodesInfoMap(graph);
		
		//create work stack
		Deque<N> stack = new LinkedList<>();
		stack.push(root);
		
		//get the correspondent node info from the map
		NodeInfo rootNodeInfo = nodesInfoMap.get(root);
		rootNodeInfo.setVisited(true);
		
		//generate list to hold result
		List<NodeInfo> resultList = new LinkedList<>();
		resultList.add(rootNodeInfo);
		
		while(!stack.isEmpty()){
			//get a node from the stack
			N currentNode = stack.pop();
			
			//discover new nodes
			Set<E> distinctEdges = graph.getDistinctEdges(currentNode);
			for (E edge : distinctEdges) {
				N adjacentNode = edge.getTarget();
				NodeInfo adjacentNodeInfo = nodesInfoMap.get(adjacentNode);
				
				//is node visited?
				if(!adjacentNodeInfo.isVisited()){
					adjacentNodeInfo.setVisited(true);
					
					stack.push(adjacentNode);
					resultList.add(adjacentNodeInfo);
				}
			}
		}
		
		return Collections.unmodifiableList(resultList);
	}
	
	private <N extends Node, E extends Edge<N>> Map<N, NodeInfo> generateNodesInfoMap(Graph<N, E> graph) {
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
	
	//XXX KRUSKAL ALGORITHM METHODS
	
	@Override
	public <N extends AbstractNode, E extends AbstractWeightedEdge<N,T>, T extends Comparable<T>> AbstractGraph<N, E> kruskal(Graph<N, E> graph) {
		checkKruskalPreConditions(graph);
		Map<N, AbstractGraph<N, E>> forest = generateForest(graph);
		Queue<E> edgesQueue = new PriorityQueue<>(graph.getDistinctEdges());
		AbstractGraph<N, E> mst = doKruskal(forest, edgesQueue);
		return mst;
	}

	private <N extends AbstractNode, E extends AbstractWeightedEdge<N,T>, T extends Comparable<T>> void checkKruskalPreConditions(Graph<N, E> graph) {
		Util.checkNullParameter(graph);
		
		if(!graph.isWeighted()){
			throw new IllegalGraphException(GRAPH_NOT_WEIGHTED_MESSAGE_KEY);
		}
		
		if(!isGraphConnected(graph)){
			throw new IllegalGraphException(GRAPH_NOT_CONNECTED_MESSAGE_KEY);
		}
		
		boolean isEmpty = graph.isEmpty();
		if(isEmpty){
			throw new IllegalGraphException(GRAPH_EMPTY_MESSAGE_KEY);
		}
	}
	
	private <E extends AbstractWeightedEdge<N, T>, N extends AbstractNode, T extends Comparable<T>> AbstractGraph<N, E> getProperGraphInstance(Graph<N, E> graph) {
		AbstractGraph<N, E> returnGraph = null;
		if(graph.isDirected()){
			returnGraph = new DefaultSDWGraph<N,E,T>();
		} else {
			returnGraph = new DefaultSUWGraph<N,E,T>();
		}
		return returnGraph;
	}
	
	private <N extends AbstractNode, E extends AbstractWeightedEdge<N,T>, T extends Comparable<T>> Map<N, AbstractGraph<N, E>> generateForest(Graph<N, E> graph) {
		Map<N, AbstractGraph<N, E>> forestMap = new LinkedHashMap<>();
		for (N node : graph.getAllNodes()) {
			AbstractGraph<N, E> treeGraph = getProperGraphInstance(graph);
			treeGraph.addNode(node);
			forestMap.put(node, treeGraph);
		}
		
		return forestMap;
	}

	private <N extends AbstractNode, E extends AbstractWeightedEdge<N,T>, T extends Comparable<T>> AbstractGraph<N, E> doKruskal(Map<N, AbstractGraph<N, E>> forest, Queue<E> edgesQueue){
		while(!edgesQueue.isEmpty()){
			E currentEdge = edgesQueue.poll();
			N sourceNode = currentEdge.getSource();
			N targetNode = currentEdge.getTarget();
			
			AbstractGraph<N, E> sourceTree = forest.get(sourceNode);
			AbstractGraph<N, E> targetTree = forest.get(targetNode);
			
			if(sourceTree.equals(targetTree)){
				continue;
			}
			
			AbstractGraph<N, E> merged = doMerge(sourceTree, targetTree);
			merged.addEdge(currentEdge);
			forest.put(targetNode, merged);
			forest.put(sourceNode, merged);
				
			if(merged.getAllNodes().size() == forest.size()){
				return merged;
			}			
		}
		
		throw new IllegalGraphException(GRAPH_NOT_CONNECTED_MESSAGE_KEY);
	}
	
	private <N extends AbstractNode, E extends AbstractWeightedEdge<N,T>, T extends Comparable<T>> AbstractGraph<N,E> doMerge(AbstractGraph<N, E> sourceTree, AbstractGraph<N, E> targetTree){
		if(sourceTree.getAllNodes().size() > targetTree.getAllNodes().size()){
			sourceTree.merge(targetTree);
			return sourceTree;
		} else{
			targetTree.merge(sourceTree);
			return targetTree;
		}
	}
	
}
