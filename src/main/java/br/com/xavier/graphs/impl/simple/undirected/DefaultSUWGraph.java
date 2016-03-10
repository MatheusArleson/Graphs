package br.com.xavier.graphs.impl.simple.undirected;

import br.com.xavier.graphs.abstractions.edges.AbstractWeightedEdge;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.abstractions.simple.undirected.SimpleUndirectedWeightedGraph;

public class DefaultSUWGraph<N extends AbstractNode, E extends AbstractWeightedEdge<N,T>, T> extends SimpleUndirectedWeightedGraph<N, E, T> {
	
	public DefaultSUWGraph() {}

}
