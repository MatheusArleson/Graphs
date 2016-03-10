package br.com.xavier.graphs.impl.simple.directed;

import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.abstractions.simple.directed.SimpleDirectedWeightedGraph;

public class DefaultSDWGraph<N extends AbstractNode, E extends AbstractWeightedEdge<N,T>, T> 
		extends SimpleDirectedWeightedGraph<N,E,T> { 
	
	public DefaultSDWGraph() {
	}
	
}
