package br.com.xavier.graphs.impl.edges;

import br.com.xavier.graphs.abstraction.edges.AbstractEdge;
import br.com.xavier.graphs.interfaces.Node;

public class DefaultUnweightedEdge extends AbstractEdge {

	private static final long serialVersionUID = -217630814014608015L;

	public DefaultUnweightedEdge(Node source, Node target) {
		super(source, target);
	}
	
}
