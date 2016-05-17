package br.com.xavier.graphs.impl.algorithms.degree;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import br.com.xavier.graphs.interfaces.Graph;
import br.com.xavier.graphs.interfaces.edges.Edge;
import br.com.xavier.graphs.interfaces.nodes.Node;
import br.com.xavier.graphs.util.Util;

public class DegreeSortAlgorithm {
	
	//XXX CONSTRUCTOR
	public DegreeSortAlgorithm() { }
	
	public <N extends Node, E extends Edge<N>> Map<Integer, List<N>> getDegreeMap(Graph<N, E> graph){
		Util.checkNullParameter(graph);
		
		Map<Integer, List<N>> degreeMap = new TreeMap<>();
		
		if(graph.isEmpty()){
			return degreeMap;
		}
		
		Set<N> allNodes = graph.getAllNodes();
		for (N node : allNodes) {
			int nodeDegree = graph.degreeOf(node);
			if(!degreeMap.containsKey(nodeDegree)){
				degreeMap.put(nodeDegree, new LinkedList<N>());
			} 
			
			degreeMap.get(nodeDegree).add(node);
		}
		
		return degreeMap;
	}
	
}
