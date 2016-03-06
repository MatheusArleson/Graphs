package br.com.xavier.graphs.interfaces.parser;

import br.com.xavier.graphs.abstractions.AbstractGraph;
import br.com.xavier.graphs.abstractions.nodes.AbstractNode;
import br.com.xavier.graphs.interfaces.edges.Edge;

public interface GraphsParser<N extends AbstractNode, E extends Edge<N>> {
	
	public String parse(AbstractGraph<N, E> graph, String graphWidgetVar);
	
}
