package br.com.xavier.graphs.impl.algorithms;

import br.com.xavier.graphs.abstractions.AbstractGraph;
import br.com.xavier.graphs.abstractions.edges.AbstractEdge;
import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.impl.simple.directed.DefaultSDUGraph;
import br.com.xavier.graphs.impl.simple.directed.DefaultSDWGraph;
import br.com.xavier.graphs.impl.simple.undirected.DefaultSUUGraph;
import br.com.xavier.graphs.impl.simple.undirected.DefaultSUWGraph;
import br.com.xavier.graphs.interfaces.Graph;

public final class GraphInstanceFactory {
	
	private GraphInstanceFactory(){}
	
	public static <N extends AbstractNode, E extends AbstractEdge<N>> AbstractGraph<N, E> getProperUnweightedGraphInstance(Graph<N, E> graph) {
		AbstractGraph<N, E> returnGraph = null;
		if(graph.isDirected()){
			returnGraph = new DefaultSDUGraph<N,E>();
		} else {
			returnGraph = new DefaultSUUGraph<N,E>();
		}
		return returnGraph;
	}
	
	public static <E extends AbstractWeightedEdge<N, T>, N extends AbstractNode, T extends Comparable<T>> AbstractGraph<N, E> getProperWeightedGraphInstance(Graph<N, E> graph) {
		AbstractGraph<N, E> returnGraph = null;
		if(graph.isDirected()){
			returnGraph = new DefaultSDWGraph<N,E,T>();
		} else {
			returnGraph = new DefaultSUWGraph<N,E,T>();
		}
		return returnGraph;
	}
	
}
