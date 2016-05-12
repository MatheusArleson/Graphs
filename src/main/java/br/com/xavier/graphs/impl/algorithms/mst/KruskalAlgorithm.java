package br.com.xavier.graphs.impl.algorithms.mst;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import br.com.xavier.graphs.abstractions.AbstractGraph;
import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.exception.IllegalGraphException;
import br.com.xavier.graphs.impl.algorithms.GraphInstanceFactory;
import br.com.xavier.graphs.impl.algorithms.transversal.ConnectedGraphAlgorithm;
import br.com.xavier.graphs.interfaces.Graph;
import br.com.xavier.graphs.util.Util;

public class KruskalAlgorithm {
	
	private static final String GRAPH_NOT_WEIGHTED_MESSAGE_KEY = "graph.not.weighted";
	private static final String GRAPH_NOT_CONNECTED_MESSAGE_KEY = "graph.not.connected";
	private static final String GRAPH_EMPTY_MESSAGE_KEY = "graph.empty";
	
	//XXX CONSTRUCTOR
	public KruskalAlgorithm() {	}
	
	//XXX METHODS
	public <N extends AbstractNode, E extends AbstractWeightedEdge<N,T>, T extends Comparable<T>> AbstractGraph<N, E> doAlgorithm(Graph<N, E> graph) {
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
	
	private <N extends AbstractNode, E extends AbstractWeightedEdge<N,T>, T extends Comparable<T>> boolean isGraphConnected(Graph<N, E> graph) {
		return new ConnectedGraphAlgorithm().checkGraphConnectionsByBFS(graph);
	}

	private <N extends AbstractNode, E extends AbstractWeightedEdge<N,T>, T extends Comparable<T>> Map<N, AbstractGraph<N, E>> generateForest(Graph<N, E> graph) {
		Map<N, AbstractGraph<N, E>> forestMap = new LinkedHashMap<>();
		for (N node : graph.getAllNodes()) {
			AbstractGraph<N, E> treeGraph = GraphInstanceFactory.getProperWeightedGraphInstance(graph);
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
